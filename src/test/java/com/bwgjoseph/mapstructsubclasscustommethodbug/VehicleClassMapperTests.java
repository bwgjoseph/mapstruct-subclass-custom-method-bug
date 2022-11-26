package com.bwgjoseph.mapstructsubclasscustommethodbug;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bwgjoseph.mapstructsubclasscustommethodbug.dto.CarClassDto;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Car;
import com.bwgjoseph.mapstructsubclasscustommethodbug.model.Vehicle.Purpose;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@Import(VehicleClassMapperImpl.class)
// @SpringBootTest
class VehicleClassMapperTests {
    @Autowired
    private VehicleClassMapper vehicleClassMapper;

    /**
     * This does not work as generated class did not generate setter for `isCar`
     */
    @Test
    void javaClassDtoToModel() {
        CarClassDto carDtoC = CarClassDto.builder().purpose(Purpose.LAND).model("A222").country("SINGAPORE").isCar(true).build();

        Car car = (Car) this.vehicleClassMapper.toDomainObject(carDtoC);
        log.info("car {}", car);

        Assertions.assertThat(car.getPurpose()).isEqualTo(Purpose.LAND);
        Assertions.assertThat(car.getModel()).isEqualTo(carDtoC.getModel());
        Assertions.assertThat(car.getCountry().getValue()).isEqualTo(carDtoC.getCountry());
        // the reason for this to fail is because the generated implementation class does not set `car` value
        Assertions.assertThat(car.isCar()).isEqualTo(carDtoC.isCar());
    }
}
