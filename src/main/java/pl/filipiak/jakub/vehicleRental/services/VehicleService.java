package pl.filipiak.jakub.vehicleRental.services;

import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;

import java.util.LinkedList;
import java.util.Optional;

public interface VehicleService {

    LinkedList<VehicleDto> getAllVehiclesWithoutBorrowInfoSortedById();

    Optional<VehicleDto> getVehicleWithBorrowInfoById(Long id);

    void deleteVehicleById(Long id);
}
