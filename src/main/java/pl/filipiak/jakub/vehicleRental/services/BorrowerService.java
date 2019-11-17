package pl.filipiak.jakub.vehicleRental.services;

import pl.filipiak.jakub.vehicleRental.models.dtos.BorrowerDto;

import java.util.LinkedList;

public interface BorrowerService {

    LinkedList<BorrowerDto> getAllBorrowersWithoutBorrowInfoSortedByName();
}
