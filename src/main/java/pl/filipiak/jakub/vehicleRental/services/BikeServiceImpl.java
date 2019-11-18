package pl.filipiak.jakub.vehicleRental.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filipiak.jakub.vehicleRental.assemblers.BikeAssembler;
import pl.filipiak.jakub.vehicleRental.models.Bike;
import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;
import pl.filipiak.jakub.vehicleRental.repositories.BikeRepository;

@Service
@Transactional
public class BikeServiceImpl implements BikeService {

    private BikeRepository bikeRepository;
    private BikeAssembler bikeAssembler;

    public BikeServiceImpl(BikeRepository bikeRepository,
                           BikeAssembler bikeAssembler) {
        this.bikeRepository = bikeRepository;
        this.bikeAssembler = bikeAssembler;
    }

    @Override
    public VehicleDto addBike(Long number) {
        Bike bikeToBeSaved = bikeAssembler.entityFromNumber(number);
        Bike bikeFromDb = bikeRepository.save(bikeToBeSaved);
        return bikeAssembler.vehicleDtoFromEntity(bikeFromDb);
    }
}
