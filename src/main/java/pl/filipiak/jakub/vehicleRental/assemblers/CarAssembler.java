package pl.filipiak.jakub.vehicleRental.assemblers;

import org.springframework.stereotype.Component;
import pl.filipiak.jakub.vehicleRental.models.Car;
import pl.filipiak.jakub.vehicleRental.models.dtos.AddCarDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.CarDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;
import pl.filipiak.jakub.vehicleRental.models.helpers.Color;

import java.time.LocalDate;

@Component
public class CarAssembler {

    public Car entityFromAddCarDto(AddCarDto addCarDto) {
        String name = retrieveName(addCarDto);
        Color color = retrieveColor(addCarDto);
        LocalDate productionDate = retrieveProductionDate(addCarDto);
        return new Car(name, color, productionDate);
    }

    public Car entityFromCarDto(CarDto carDto) {
        Long id = retrieveId(carDto);
        String name = retrieveName(carDto);
        Color color = retrieveColor(carDto);
        LocalDate productionDate = retrieveProductionDate(carDto);
        return new Car(id, name, color, productionDate);
    }

    public VehicleDto vehicleDtoFromEntity(Car entity) {
        return VehicleDto.builder()
                .id(retrieveId(entity))
                .type(retrieveVehicleType(entity))
                .nameOrNumber(retrieveNameOrNumber(entity))
                .producerName(retrieveProducerName(entity))
                .color(retrieveColor(entity))
                .productionDate(retrieveProductionDate(entity))
                .build();
    }

    private long retrieveId(Car entity) {
        return entity.getId();
    }

    private Long retrieveId(CarDto carDto) {
        return carDto.getId();
    }

    private String retrieveVehicleType(Car entity) {
        return entity.getType().getStringValue();
    }

    private String retrieveNameOrNumber(Car entity) {
        return entity.getName();
    }

    private String retrieveName(AddCarDto addCarDto) {
        return addCarDto.getName();
    }

    private String retrieveName(CarDto carDto) {
        return carDto.getName();
    }

    private String retrieveProducerName(Car entity) {
        return entity.getProducer().getName();
    }

    private String retrieveColor(Car entity) {
        return entity.getColor().getStringValue();
    }

    private Color retrieveColor(AddCarDto addCarDto) {
        return Color.fromString(addCarDto.getColor());
    }

    private Color retrieveColor(CarDto carDto) {
        return Color.fromString(carDto.getColor());
    }

    private String retrieveProductionDate(Car entity) {
        return entity.getProductionDate().toString();
    }

    private LocalDate retrieveProductionDate(AddCarDto addCarDto) {
        return LocalDate.parse(addCarDto.getProductionDate());
    }

    private LocalDate retrieveProductionDate(CarDto carDto) {
        return LocalDate.parse(carDto.getProductionDate());
    }
}
