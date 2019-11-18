package pl.filipiak.jakub.vehicleRental.services;

import pl.filipiak.jakub.vehicleRental.models.dtos.ProducerDto;

import java.util.Optional;

public interface ProducerService {

    ProducerDto addProducer(String name);

    Optional<ProducerDto> getProducerByName(String name);

    void deleteProducerByNameIfDeprecated(String name);
}
