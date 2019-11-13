package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bike")
public class BikeController {

    @PostMapping("/{number}")
    public ResponseEntity<?> addBike(@PathVariable Long number) {
        return null;
    }
}
