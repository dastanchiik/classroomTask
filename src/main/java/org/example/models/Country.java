package org.example.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Country {
    private Long id;
    private String name;
    private Long population;

    public Country() {
    }

    public Country(String name, Long population) {
        this.name = name;
        this.population = population;
    }
}
