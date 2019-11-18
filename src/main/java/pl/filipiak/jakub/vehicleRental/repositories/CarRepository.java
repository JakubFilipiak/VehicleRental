package pl.filipiak.jakub.vehicleRental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.filipiak.jakub.vehicleRental.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
