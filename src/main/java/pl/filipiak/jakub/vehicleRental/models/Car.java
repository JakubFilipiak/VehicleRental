package pl.filipiak.jakub.vehicleRental.models;

import pl.filipiak.jakub.vehicleRental.models.helpers.Color;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Car extends Vehicle {

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @Enumerated(EnumType.STRING)
    private Color color;

    private LocalDate productionDate;
}
