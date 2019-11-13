package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
