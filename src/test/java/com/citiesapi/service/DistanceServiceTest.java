package com.citiesapi.service;

import com.citiesapi.entities.City;
import com.citiesapi.repository.CityRepository;
import com.citiesapi.utils.EarthRadius;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class DistanceServiceTest {
    @Autowired
    private DistanceService service;

    @MockBean
    private CityRepository cityRepository;

    private City saoCarlos;
    private City ibate;

    @BeforeEach
    public void setUp() {
        ibate = new City(4929L, "Ibaté", 26, 3519303, "(-21.95840072631836,-47.98820114135742)",
                new Point(-21.95840072631836, -47.98820114135742));
        saoCarlos =
                new City(5254L, "São Carlos", 26, 3548906, "(-22.01740074157715,-47.88600158691406)",
                        new Point(-22.01740074157715, -47.88600158691406));
        Logger log = LoggerFactory.getLogger(DistanceService.class);

    }

    @Test
    public void shouldCalculateInMetersUsingMath() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.METERS);

        assertThat(distance).isEqualTo(12426.810463475855);
    }

    @Test
    public void shouldCalculateInKilometersUsingMath() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.KILOMETERS);

        assertThat(distance).isCloseTo(12.426, offset(0.001d));
    }

    @Test
    public void shouldCalculateInMilesUsingMath() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.MILES);

        assertThat(distance).isCloseTo(7.71, offset(0.01d));
    }

    @Test
    public void shouldCalculateInMetersUsingPoints() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceUsingPoints(4929L, 5254L, EarthRadius.METERS);

        assertThat(distance).isEqualTo(12426.810463475855);
    }
    @Test
    public void shouldCalculateInMilesUsingPoints() {

        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceByPointsInMiles(4929L,5254L);

        assertThat(distance).isEqualTo(12426.810463475855);
    }

}