package pl.filipiak.jakub.vehicleRental.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    private Set<Borrow> borrows;
}
