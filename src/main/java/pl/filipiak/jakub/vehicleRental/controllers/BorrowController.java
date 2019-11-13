package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    @GetMapping("/{date}")
    public ResponseEntity<?> getBorrowedVehiclesWithRentalInfoByDate(@PathVariable LocalDate date) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> addRental(@RequestBody BorrowDto borrowDto) {
        return null;
    }
}
