package pl.filipiak.jakub.vehicleRental.services;

import pl.filipiak.jakub.vehicleRental.models.dtos.AddBorrowDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.BorrowDto;

import java.time.LocalDate;
import java.util.LinkedList;

public interface BorrowService {

    BorrowDto addBorrow(AddBorrowDto addBorrowDto);

    LinkedList<BorrowDto> getBorrowsForAllVehiclesByDateSortedByVehicleId(LocalDate date);
}
