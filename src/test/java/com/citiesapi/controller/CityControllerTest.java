package com.citiesapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void shouldReturnAPageOfCity{
        String response =
                restTemplate.getForObject(http://localhost:"+port+"cities", String.class)
    assertThat(response).contains("Ibaté");
    assertThat(response).contains("São Carlos");
    }
}
