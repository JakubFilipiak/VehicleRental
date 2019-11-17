package pl.filipiak.jakub.vehicleRental.services;

import pl.filipiak.jakub.vehicleRental.models.dtos.AddCarDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.CarDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;

public interface CarService {

    VehicleDto addCar(AddCarDto addCarDto);

    VehicleDto updateCar(CarDto carDto);
}
