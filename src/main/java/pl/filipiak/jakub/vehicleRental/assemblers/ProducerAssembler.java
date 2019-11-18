package pl.filipiak.jakub.vehicleRental.assemblers;

import org.springframework.stereotype.Component;
import pl.filipiak.jakub.vehicleRental.models.Producer;
import pl.filipiak.jakub.vehicleRental.models.dtos.ProducerDto;

@Component
public class ProducerAssembler {

    public Producer entityFromName(String name) {
        return new Producer(name);
    }

    public Producer entityFromProducerDto(ProducerDto producerDto) {
        Long id = retrieveId(producerDto);
        String name = retrieveName(producerDto);
        return new Producer(id, name);
    }

    public ProducerDto producerDtoFromEntity(Producer producer) {
        long id = retrieveId(producer);
        String name = retrieveName(producer);
        return new ProducerDto(id, name);
    }

    private long retrieveId(Producer producer) {
        return producer.getId();
    }

    private Long retrieveId(ProducerDto producerDto) {
        return producerDto.getId();
    }

    private String retrieveName(Producer producer) {
        return producer.getName();
    }

    private String retrieveName(ProducerDto producerDto) {
        return producerDto.getName();
    }
}
