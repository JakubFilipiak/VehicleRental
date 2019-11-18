package pl.filipiak.jakub.vehicleRental.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import pl.filipiak.jakub.vehicleRental.models.dtos.ProducerDto;

import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
@TestPropertySource("classpath:testDb.properties")
class ProducerServiceImplTest {

    @Autowired
    private ProducerService producerService;

    @Test
    public void shouldCorrectAddProducer() {
        // given
        String givenProducerName = String.valueOf(new Random().nextInt());

        // when
        ProducerDto producerSaved = producerService.addProducer(givenProducerName);

        // then
        assertThat(producerSaved).isNotNull();
        assertThat(producerSaved.getName()).isEqualTo(givenProducerName);
    }

    @Test
    public void shouldCorrectGetProducerByNameWhenProduceExists() {
        // given
        String givenProducerName = String.valueOf(new Random().nextInt());
        ProducerDto givenProducer = producerService.addProducer(givenProducerName);

        // when
        Optional<ProducerDto> producerFromDbOpt = producerService.getProducerByName(givenProducerName);

        // then
        assertThat(producerFromDbOpt).isNotEmpty();
        assertThat(producerFromDbOpt.get()).isEqualTo(givenProducer);
    }

    @Test
    public void shouldCorrectGetProducerByNameWhenProducerNotExists() {
        // given
        String givenProducerName = String.valueOf(new Random().nextInt());

        // when
        Optional<ProducerDto> producerFromDbOpt = producerService.getProducerByName(givenProducerName);

        // then
        assertThat(producerFromDbOpt).isEmpty();
    }

    @Test
    public void shouldDeleteProducerWhenNoCarsInRelation() {
        // given
        String givenProducerName = String.valueOf(new Random().nextInt());
        ProducerDto givenProducer = producerService.addProducer(givenProducerName);

        // when
        producerService.deleteProducerByNameIfDeprecated(givenProducerName);
        Optional<ProducerDto> producerFromDbOpt = producerService.getProducerByName(givenProducerName);

        // then
        assertThat(producerFromDbOpt).isEmpty();
    }
}