package pl.filipiak.jakub.vehicleRental.models.dtos;

import lombok.Getter;

@Getter
public class AddCarDto {

    private String name;
    private String producerName;
    private String color;
    private String productionDate;
}
