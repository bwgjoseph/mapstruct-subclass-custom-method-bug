package com.bwgjoseph.mapstructsubclasscustommethodbug;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.SubclassExhaustiveStrategy;

import com.bwgjoseph.mapstructsubclasscustommethodbug.dto.CarClassDto;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Car;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.CountryWrapper;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Vehicle;

@Mapper(componentModel = "spring", subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface VehicleClassMapper {
    @BeanMapping(resultType = Car.class)
    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    // VehicleClassMapperImpl is not generating the setter for `isCar`, hence causing the problem
    Vehicle toDomainObject(CarClassDto carDto);

    @Named("mapCountry")
    default CountryWrapper mapCountry(String country) {
        return CountryWrapper.of(country);
    }

    // ignore below

    // this is not ok but this should work
    // @SubclassMapping(source = CarDtoC.class, target = Car.class)
    // @BeanMapping(resultType = Car.class)
    // @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    // Vehicle toDomainObject(CarDtoC carDto);

    // @BeanMapping(resultType = Lorry.class)
    // @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    // Vehicle toDomainObject(LorryDtoC lorryDto);

    // this is ok
    // @SubclassMapping(source = CarDtoC.class, target = Car.class)
    // @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    // Car toDomainObject(CarDtoC carDto);

    // this is not ok
    // The return type Vehicle is an abstract class or interface. Provide a non abstract / non interface result type or a factory method.
    // Vehicle toDomainObject(CarDtoC carDto);
}
