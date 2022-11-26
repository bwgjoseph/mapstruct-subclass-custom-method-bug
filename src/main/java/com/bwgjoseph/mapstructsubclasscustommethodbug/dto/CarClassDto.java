package com.bwgjoseph.mapstructsubclasscustommethodbug.dto;

import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Vehicle.Purpose;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CarClassDto {
    private Purpose purpose;
    private String model;
    private String country;
    private boolean isCar;
}
