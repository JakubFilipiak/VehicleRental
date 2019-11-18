package pl.filipiak.jakub.vehicleRental.models;

import lombok.Getter;
import lombok.Setter;
import pl.filipiak.jakub.vehicleRental.models.helpers.VehicleType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private Set<Borrow> borrows = new HashSet<>();
}
