package pl.filipiak.jakub.vehicleRental.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL)
    private Set<Car> cars;
}
