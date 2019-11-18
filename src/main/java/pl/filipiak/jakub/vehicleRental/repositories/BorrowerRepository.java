package pl.filipiak.jakub.vehicleRental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.filipiak.jakub.vehicleRental.models.Borrower;

import java.util.LinkedList;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

    @Query("SELECT b from Borrower b ORDER BY b.id")
    LinkedList<Borrower> findAllOrderByName();
}
