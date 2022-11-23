package com.bwgjoseph.mapstructsubclasscustommethodbug.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public abstract class Vehicle {
    public enum Purpose { LAND, AIR }

    private Purpose purpose;
    private String model;
    private CountryWrapper country;
}
