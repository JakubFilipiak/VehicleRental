package pl.filipiak.jakub.vehicleRental.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filipiak.jakub.vehicleRental.assemblers.CarAssembler;
import pl.filipiak.jakub.vehicleRental.assemblers.ProducerAssembler;
import pl.filipiak.jakub.vehicleRental.models.Car;
import pl.filipiak.jakub.vehicleRental.models.dtos.AddCarDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.CarDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.ProducerDto;
import pl.filipiak.jakub.vehicleRental.models.dtos.VehicleDto;
import pl.filipiak.jakub.vehicleRental.repositories.CarRepository;

import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private CarAssembler carAssembler;
    private ProducerService producerService;
    private ProducerAssembler producerAssembler;

    public CarServiceImpl(CarRepository carRepository,
                          CarAssembler carAssembler,
                          ProducerService producerService,
                          ProducerAssembler producerAssembler) {
        this.carRepository = carRepository;
        this.carAssembler = carAssembler;
        this.producerService = producerService;
        this.producerAssembler = producerAssembler;
    }

    @Override
    public VehicleDto addCar(AddCarDto addCarDto) {
        Car carToBeSaved = carAssembler.entityFromAddCarDto(addCarDto);
        assignProducerToCar(addCarDto.getProducerName(), carToBeSaved);
        Car carFromDb = carRepository.save(carToBeSaved);
        return carAssembler.vehicleDtoFromEntity(carFromDb);
    }

    @Override
    public VehicleDto updateCar(CarDto carDto) {
        Car carToBeSaved = carAssembler.entityFromCarDto(carDto);
        String previousProducerName = retrievePreviousProducerName(carToBeSaved);
        String actualProducerName = carDto.getProducerName();
        assignProducerToCar(actualProducerName, carToBeSaved);
        Car carFromDb = carRepository.save(carToBeSaved);
        removeDeprecatedProducer(previousProducerName, actualProducerName);
        return carAssembler.vehicleDtoFromEntity(carFromDb);
    }

    private String retrievePreviousProducerName(Car car) {
        Optional<Car> carFromDbOpt = carRepository.findById(car.getId());
        if (carFromDbOpt.isPresent()) {
            Car carFromDb = carFromDbOpt.get();
            if (carFromDb.getProducer() != null) return carFromDb.getProducer().getName();
        }
        return null;
    }

    private void assignProducerToCar(String producerName, Car car) {
        if (producerName == null) return;
        producerService.getProducerByName(producerName).ifPresentOrElse(
                producerDto -> {
                    car.setProducer(producerAssembler.entityFromProducerDto(producerDto));
                },
                () -> {
                    ProducerDto createdProducerDto = producerService.addProducer(producerName);
                    car.setProducer(producerAssembler.entityFromProducerDto(createdProducerDto));
                });
    }

    private void removeDeprecatedProducer(String previousProducerName, String actualProducerName) {
        if (previousProducerName == null) return;
        if (actualProducerName.equals(previousProducerName)) return;
        producerService.deleteProducerByNameIfDeprecated(previousProducerName);
    }
}
