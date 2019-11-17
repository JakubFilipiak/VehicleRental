package pl.filipiak.jakub.vehicleRental.services;

import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;

import java.util.LinkedList;

public interface VehicleService {

    LinkedList<VehicleDto> getAllVehiclesWithoutBorrowInfoSortedById();

    VehicleDto getVehicleWithBorrowInfoById(Long id);

    void deleteVehicleById(Long id);
}
