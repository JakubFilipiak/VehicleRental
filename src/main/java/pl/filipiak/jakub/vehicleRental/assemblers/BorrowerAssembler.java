package pl.filipiak.jakub.vehicleRental.assemblers;

import org.springframework.stereotype.Component;
import pl.filipiak.jakub.vehicleRental.models.Borrower;
import pl.filipiak.jakub.vehicleRental.models.dtos.BorrowerDto;

@Component
public class BorrowerAssembler {

    public BorrowerDto borrowerDtoFromEntity(Borrower borrower) {
        long id = retrieveId(borrower);
        String name = retrieveName(borrower);
        return new BorrowerDto(id, name);
    }

    private long retrieveId(Borrower borrower) {
        return borrower.getId();
    }

    private String retrieveName(Borrower borrower) {
        return borrower.getName();
    }
}
