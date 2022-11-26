package com.bwgjoseph.mapstructsubclasscustommethodbug;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bwgjoseph.mapstructsubclasscustommethodbug.dto.CarRecordDto;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Car;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Vehicle.Purpose;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class VehicleRecordMapperTests {
    @Autowired
    private VehicleRecordMapper vehicleRecordMapper;

    @Test
    void javaRecordDtoToModel() {
        CarRecordDto carDto = new CarRecordDto("LAND", "A111", "SINGAPORE", true);

        Car car = (Car) this.vehicleRecordMapper.toDomainObject(carDto);
        log.info("car {}", car);

        Assertions.assertThat(car.getPurpose()).isEqualTo(Purpose.LAND);
        Assertions.assertThat(car.getModel()).isEqualTo(carDto.model());
        Assertions.assertThat(car.getCountry().getValue()).isEqualTo(carDto.country());
        // the reason for this to fail is because the generated implementation class does not set `car` value
        Assertions.assertThat(car.isCar()).isEqualTo(carDto.isCar());
    }
}
