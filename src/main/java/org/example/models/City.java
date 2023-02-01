package org.example.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City {
    private Long id;
    private String name;

    public City(){

    }

    public City(String name) {
        this.name = name;
    }
}
