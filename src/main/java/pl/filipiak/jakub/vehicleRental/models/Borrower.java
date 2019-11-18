package pl.filipiak.jakub.vehicleRental.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    private Set<Borrow> borrows;
}
