package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filipiak.jakub.vehicleRental.models.dtos.AddCarDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.CarDto;
import pl.filipiak.jakub.vehicleRental.services.CarService;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private CarService carService;

    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody AddCarDto addCarDto) {
        carService.addCar(addCarDto);
        return null;
    }

    @PutMapping
    public ResponseEntity<?> updateCar(@RequestBody CarDto carDto) {
        carService.updateCar(carDto);
        return null;
    }
}
