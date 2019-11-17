package pl.filipiak.jakub.vehicleRental.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle {

    @Column(unique = true)
    private long number;
}
