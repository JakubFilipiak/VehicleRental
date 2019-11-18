package pl.filipiak.jakub.vehicleRental.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
@TestPropertySource("classpath:testDb.properties")
class BikeServiceImplTest {

    @Autowired
    private BikeService bikeService;

    @Test
    public void shouldCorrectAddBike() {
        // given
        long givenBikeNumber = new Random().nextLong();

        // when
        VehicleDto bikeSaved = bikeService.addBike(givenBikeNumber);

        // then
        assertThat(bikeSaved).isNotNull();
        assertThat(bikeSaved.getNameOrNumber()).isEqualTo(String.valueOf(givenBikeNumber));
    }
}