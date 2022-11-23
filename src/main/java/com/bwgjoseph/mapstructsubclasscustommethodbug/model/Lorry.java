package com.bwgjoseph.mapstructsubclasscustommethodbug.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class Lorry extends Vehicle {
    private boolean isLorry;
}
