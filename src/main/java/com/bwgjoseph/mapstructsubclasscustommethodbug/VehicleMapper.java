package com.bwgjoseph.mapstructsubclasscustommethodbug;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;

import com.bwgjoseph.mapstructsubclasscustommethodbug.dto.CarDtoC;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Car;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.CountryWrapper;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Vehicle;

@Mapper(componentModel = "spring", subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface VehicleMapper {
    // this is not ok but this should work
    @SubclassMapping(source = CarDtoC.class, target = Car.class)
    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    Vehicle toDomainObject(CarDtoC carDto);

    // this is ok
    // @SubclassMapping(source = CarDtoC.class, target = Car.class)
    // @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    // Car toDomainObject(CarDtoC carDto);

    // this is not ok
    // The return type Vehicle is an abstract class or interface. Provide a non abstract / non interface result type or a factory method.
    // Vehicle toDomainObject(CarDtoC carDto);

    @Named("mapCountry")
    default CountryWrapper mapCountry(String country) {
        return CountryWrapper.of(country);
    }
}
