package com.bwgjoseph.mapstructsubclasscustommethodbug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bwgjoseph.mapstructsubclasscustommethodbug.dto.CarDtoC;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Vehicle;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Vehicle.Purpose;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class VehicleMapperTests {
    @Autowired
    private VehicleMapper vehicleMapper;

    @Test
    void test1() {
        // CarDtoC carDto = new CarDto("LAND", "A111", "SINGAPORE", true);
        CarDtoC carDtoC = CarDtoC.builder().purpose(Purpose.LAND).model("A222").country("SINGAPORE").isCar(true).build();

        Vehicle car = this.vehicleMapper.toDomainObject(carDtoC);
        log.info("car {}", car);
    }
}
