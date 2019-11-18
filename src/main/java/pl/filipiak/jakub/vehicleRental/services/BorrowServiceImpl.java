package pl.filipiak.jakub.vehicleRental.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filipiak.jakub.vehicleRental.models.dtos.AddBorrowDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.BorrowDto;

import java.time.LocalDate;
import java.util.LinkedList;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Override
    public BorrowDto addBorrow(AddBorrowDto addBorrowDto) {
        return null;
    }

    @Override
    public LinkedList<BorrowDto> getBorrowsForAllVehiclesByDateSortedByVehicleId(LocalDate date) {
        return null;
    }
}
