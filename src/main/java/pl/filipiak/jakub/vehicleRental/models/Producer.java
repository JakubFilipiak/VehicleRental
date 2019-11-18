package pl.filipiak.jakub.vehicleRental.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<>();

    private Producer() {} // for Hibernate

    public Producer(String name) {
        this.name = name;
    }

    public Producer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
