package com.bwgjoseph.mapstructsubclasscustommethodbug;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.bwgjoseph.mapstructsubclasscustommethodbug.dto.CarRecordDto;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Car;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.CountryWrapper;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleRecordMapper {
    @BeanMapping(resultType = Car.class)
    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    Vehicle toDomainObject(CarRecordDto carDto);

    @Named("mapCountry")
    default CountryWrapper mapCountry(String country) {
        return CountryWrapper.of(country);
    }
}
