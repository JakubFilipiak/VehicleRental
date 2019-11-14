package pl.filipiak.jakub.vehicleRental.models;

import pl.filipiak.jakub.vehicleRental.models.helpers.VehicleType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private Set<Borrow> borrows;
}
