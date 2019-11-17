package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filipiak.jakub.vehicleRental.models.dtos.AddBorrowDto;
import pl.filipiak.jakub.vehicleRental.services.BorrowService;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    private BorrowService borrowService;

    @GetMapping("/{date}")
    public ResponseEntity<?> getBorrowsForAllVehiclesByDate(@PathVariable LocalDate date) {
        borrowService.getBorrowsForAllVehiclesByDateSortedByVehicleId(date);
        return null;
    }

    @PostMapping
    public ResponseEntity<?> addBorrow(@RequestBody AddBorrowDto addBorrowDto) {
        borrowService.addBorrow(addBorrowDto);
        return null;
    }
}
