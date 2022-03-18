package com.citiesapi.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
@Data
@NoArgsConstructor
public class Country {

    @Id
    private Long id;
    @Column(name="nome")
    private String name;
    @Column(name="nome_pt")
    private String namePortuguese;
    @Column(name="sigla")
    private String code;
    private Integer bacen;

}
