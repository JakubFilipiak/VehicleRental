package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filipiak.jakub.vehicleRental.services.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> getVehicles() {
        vehicleService.getAllVehiclesWithoutBorrowInfoSortedById();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id) {
        vehicleService.getVehicleWithBorrowInfoById(id);
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicleById(@PathVariable Long id) {
        vehicleService.deleteVehicleById(id);
        return null;
    }
}
