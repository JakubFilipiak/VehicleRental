package pl.filipiak.jakub.vehicleRental.assemblers;

import org.springframework.stereotype.Component;
import pl.filipiak.jakub.vehicleRental.models.Borrow;
import pl.filipiak.jakub.vehicleRental.models.dtos.BorrowDto;

@Component
public class BorrowAssembler {

    public BorrowDto borrowDtoFromEntity(Borrow borrow) {
        long id = retrieveId(borrow);
        String date = retrieveDate(borrow);
        return new BorrowDto(id, date);
    }

    private long retrieveId(Borrow borrow) {
        return borrow.getId();
    }

    private String retrieveDate(Borrow borrow) {
        return borrow.getDate().toString();
    }
}
