package pl.filipiak.jakub.vehicleRental.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filipiak.jakub.vehicleRental.assemblers.ProducerAssembler;
import pl.filipiak.jakub.vehicleRental.models.Producer;
import pl.filipiak.jakub.vehicleRental.models.dtos.ProducerDto;
import pl.filipiak.jakub.vehicleRental.repositories.ProducerRepository;

import java.util.Optional;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {

    private ProducerRepository producerRepository;
    private ProducerAssembler producerAssembler;

    public ProducerServiceImpl(ProducerRepository producerRepository,
                               ProducerAssembler producerAssembler) {
        this.producerRepository = producerRepository;
        this.producerAssembler = producerAssembler;
    }

    @Override
    public ProducerDto addProducer(String name) {
        Producer producerToBeSaved = producerAssembler.entityFromName(name);
        Producer producerFromDb = producerRepository.save(producerToBeSaved);
        return producerAssembler.producerDtoFromEntity(producerFromDb);
    }

    @Override
    public Optional<ProducerDto> getProducerByName(String name) {
        Optional<Producer> producerOpt = producerRepository.findByName(name);
        if (producerOpt.isPresent()) {
            Producer producer = producerOpt.get();
            return Optional.of(producerAssembler.producerDtoFromEntity(producer));
        }
        return Optional.empty();
    }

    @Override
    public void deleteProducerByNameIfDeprecated(String name) {
        producerRepository.findByName(name).ifPresent(producer -> {
            if (producer.getCars().isEmpty()) producerRepository.delete(producer);
        });
    }
}
