package pl.filipiak.jakub.vehicleRental.assemblers;

import org.springframework.stereotype.Component;
import pl.filipiak.jakub.vehicleRental.models.Bike;
import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;

@Component
public class BikeAssembler {

    public Bike entityFromNumber(long number) {
        return new Bike(number);
    }

    public VehicleDto vehicleDtoFromEntity(Bike entity) {
        if (entity == null) return null;
        return VehicleDto.builder()
                .id(retrieveId(entity))
                .type(retrieveVehicleType(entity))
                .nameOrNumber(retrieveNameOrNumber(entity))
                .build();
    }

    private long retrieveId(Bike entity) {
        return entity.getId();
    }

    private String retrieveVehicleType(Bike entity) {
        return entity.getType().getStringValue();
    }

    private String retrieveNameOrNumber(Bike entity) {
        return String.valueOf(entity.getNumber());
    }
}
