package pl.filipiak.jakub.vehicleRental.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    private LocalDate date;
}
