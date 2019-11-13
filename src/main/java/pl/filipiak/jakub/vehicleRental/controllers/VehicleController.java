package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @GetMapping
    public ResponseEntity<?> getVehicles() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicleById(@PathVariable Long id) {
        return null;
    }
}
