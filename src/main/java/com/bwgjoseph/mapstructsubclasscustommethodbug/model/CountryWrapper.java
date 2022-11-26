package com.bwgjoseph.mapstructsubclasscustommethodbug.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CountryWrapper {
    private String value;
    private Country country;

    CountryWrapper(String value, Country country) {
        this.value = value;
        this.country = country;
    }

    public static CountryWrapper of(String value) {
        return new CountryWrapper(value, Country.valueOf(value));
    }
}
