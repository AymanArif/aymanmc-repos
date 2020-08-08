package com.ayman.quarkustesting.country;


import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

// Country DTO
public class Country {

    private final String name;
    private final String capital;

    @JsonbCreator
    public Country(@JsonbProperty("name") String name, @JsonbProperty("capital") String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }
}
