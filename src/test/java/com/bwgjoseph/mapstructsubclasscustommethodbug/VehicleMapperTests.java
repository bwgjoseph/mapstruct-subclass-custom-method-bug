package com.bwgjoseph.mapstructsubclasscustommethodbug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class VehicleMapperTests {
    @Autowired
    private VehicleMapper vehicleMapper;

    // @Test
    // void javaClassDtoToModel() {
    //     CarDtoC carDtoC = CarDtoC.builder().purpose(Purpose.LAND).model("A222").country("SINGAPORE").isCar(true).build();

    //     Vehicle car = this.vehicleMapper.toDomainObject(carDtoC);
    //     log.info("car {}", car);
    // }

    // @Test
    // void javaRecordDtoToModel() {
    //     // this does not work
    //     // throws
    //     CarDto carDto = new CarDto("LAND", "A111", "SINGAPORE", true);

    //     Vehicle car = this.vehicleMapper.toDomainObject(carDto);
    //     log.info("car {}", car);
    // }
}
