package pl.filipiak.jakub.vehicleRental.models.dtos;

import lombok.*;

import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class VehicleDto {

    private long id;
    private String type;
    private String nameOrNumber;
    private String producerName;
    private String color;
    private String productionDate;

    @Setter
    private Set<BorrowDto> borrows;
}
