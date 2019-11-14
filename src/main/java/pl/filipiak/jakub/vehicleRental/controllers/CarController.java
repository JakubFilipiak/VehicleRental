package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filipiak.jakub.vehicleRental.models.dtos.CarDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.EditCarDto;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody CarDto carDto) {
        return null;
    }

    @PutMapping
    public ResponseEntity<?> updateCar(@RequestBody EditCarDto editCarDto) {
        return null;
    }
}
