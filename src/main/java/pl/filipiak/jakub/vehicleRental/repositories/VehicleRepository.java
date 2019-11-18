package pl.filipiak.jakub.vehicleRental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.filipiak.jakub.vehicleRental.models.Vehicle;

import java.util.LinkedList;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v From Vehicle v ORDER BY v.id")
    LinkedList<Vehicle> findAllOrderById();
}
