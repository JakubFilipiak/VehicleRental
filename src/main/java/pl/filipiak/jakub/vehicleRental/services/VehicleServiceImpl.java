package pl.filipiak.jakub.vehicleRental.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filipiak.jakub.vehicleRental.assemblers.BikeAssembler;
import pl.filipiak.jakub.vehicleRental.assemblers.BorrowAssembler;
import pl.filipiak.jakub.vehicleRental.assemblers.BorrowerAssembler;
import pl.filipiak.jakub.vehicleRental.assemblers.CarAssembler;
import pl.filipiak.jakub.vehicleRental.models.*;
import pl.filipiak.jakub.vehicleRental.models.dtos.BorrowDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.BorrowerDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;
import pl.filipiak.jakub.vehicleRental.repositories.VehicleRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    private BikeAssembler bikeAssembler;
    private CarAssembler carAssembler;
    private BorrowAssembler borrowAssembler;
    private BorrowerAssembler borrowerAssembler;

    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              BikeAssembler bikeAssembler,
                              CarAssembler carAssembler,
                              BorrowAssembler borrowAssembler,
                              BorrowerAssembler borrowerAssembler) {
        this.vehicleRepository = vehicleRepository;
        this.bikeAssembler = bikeAssembler;
        this.carAssembler = carAssembler;
        this.borrowAssembler = borrowAssembler;
        this.borrowerAssembler = borrowerAssembler;
    }

    @Override
    public LinkedList<VehicleDto> getAllVehiclesWithoutBorrowInfoSortedById() {
        LinkedList<Vehicle> vehiclesFromDb = vehicleRepository.findAllOrderById();
        LinkedList<VehicleDto> vehiclesDto = new LinkedList<>();
        vehiclesFromDb.forEach(vehicleEntity -> {
            switch (vehicleEntity.getType()) {
                case BIKE:
                    Bike bikeEntity = (Bike) vehicleEntity;
                    VehicleDto bikeDto = bikeAssembler.vehicleDtoFromEntity(bikeEntity);
                    vehiclesDto.add(bikeDto);
                    break;
                case CAR:
                    Car carEntity = (Car) vehicleEntity;
                    VehicleDto carDto = carAssembler.vehicleDtoFromEntity(carEntity);
                    vehiclesDto.add(carDto);
                    break;
            }
        });
        return vehiclesDto;
    }

    @Override
    public Optional<VehicleDto> getVehicleWithBorrowInfoById(Long id) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            switch (vehicle.getType()) {
                case BIKE:
                    Bike bike = (Bike) vehicle;
                    VehicleDto bikeDto = bikeAssembler.vehicleDtoFromEntity(bike);
                    assignBorrowsToVehicleDto(bike.getBorrows(), bikeDto);
                    return Optional.of(bikeDto);
                case CAR:
                    Car car = (Car) vehicle;
                    VehicleDto carDto = carAssembler.vehicleDtoFromEntity(car);
                    assignBorrowsToVehicleDto(car.getBorrows(), carDto);
                    return Optional.of(carDto);
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteVehicleById(Long id) {
        vehicleRepository.deleteById(id);
    }

    private void assignBorrowsToVehicleDto(Set<Borrow> borrows, VehicleDto vehicleDto) {
        if (borrows == null || borrows.isEmpty()) return;
        Set<BorrowDto> borrowsDto = new HashSet<>();
        borrows.forEach(borrow -> {
            BorrowDto borrowDto = borrowAssembler.borrowDtoFromEntity(borrow);
            Borrower borrower = borrow.getBorrower();
            assignBorrowerToBorrowDto(borrower, borrowDto);
            borrowsDto.add(borrowDto);
        });
        vehicleDto.setBorrows(borrowsDto);
    }

    private void assignBorrowerToBorrowDto(Borrower borrower, BorrowDto borrowDto) {
        if (borrower == null) return;
        BorrowerDto borrowerDto = borrowerAssembler.borrowerDtoFromEntity(borrower);
        borrowDto.setBorrowerDto(borrowerDto);
    }
}
