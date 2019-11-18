package pl.filipiak.jakub.vehicleRental.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filipiak.jakub.vehicleRental.assemblers.BorrowerAssembler;
import pl.filipiak.jakub.vehicleRental.models.Borrower;
import pl.filipiak.jakub.vehicleRental.models.dtos.BorrowerDto;
import pl.filipiak.jakub.vehicleRental.repositories.BorrowerRepository;

import java.util.LinkedList;

@Service
@Transactional
public class BorrowerServiceImpl implements BorrowerService {

    private BorrowerRepository borrowerRepository;
    private BorrowerAssembler borrowerAssembler;

    public BorrowerServiceImpl(BorrowerRepository borrowerRepository,
                               BorrowerAssembler borrowerAssembler) {
        this.borrowerRepository = borrowerRepository;
        this.borrowerAssembler = borrowerAssembler;
    }

    @Override
    public LinkedList<BorrowerDto> getAllBorrowersWithoutBorrowInfoSortedByName() {
        LinkedList<Borrower> borrowersFromDb = borrowerRepository.findAllOrderByName();
        LinkedList<BorrowerDto> borrowersDto = new LinkedList<>();
        borrowersFromDb.forEach(borrower -> {
            BorrowerDto borrowerDto = borrowerAssembler.borrowerDtoFromEntity(borrower);
            borrowersDto.add(borrowerDto);
        });
        return borrowersDto;
    }
}
