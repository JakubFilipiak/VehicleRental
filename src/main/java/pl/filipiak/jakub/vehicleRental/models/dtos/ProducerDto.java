package pl.filipiak.jakub.vehicleRental.models.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ProducerDto {

    private long id;
    private String name;

    public ProducerDto(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
