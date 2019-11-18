package pl.filipiak.jakub.vehicleRental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.filipiak.jakub.vehicleRental.models.Producer;

import java.util.Optional;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

    Optional<Producer> findByName(String name);
}
