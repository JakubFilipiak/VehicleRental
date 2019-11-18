package pl.filipiak.jakub.vehicleRental.models;

import lombok.Getter;
import pl.filipiak.jakub.vehicleRental.models.helpers.VehicleType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Entity
public class Bike extends Vehicle {

    @Column(unique = true, nullable = false)
    private long number;

    private Bike() {} // for Hibernate

    public Bike(long number) {
        super();
        super.setType(VehicleType.BIKE);
        this.number = number;
    }
}
