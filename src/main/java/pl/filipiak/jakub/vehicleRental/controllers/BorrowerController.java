package pl.filipiak.jakub.vehicleRental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.filipiak.jakub.vehicleRental.services.BorrowerService;

@RestController
@RequestMapping("/api/borrower")
public class BorrowerController {

    private BorrowerService borrowerService;

    @GetMapping
    public ResponseEntity<?> getBorrowers() {
        borrowerService.getAllBorrowersWithoutBorrowInfoSortedByName();
        return null;
    }
}
