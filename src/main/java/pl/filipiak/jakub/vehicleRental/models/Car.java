package pl.filipiak.jakub.vehicleRental.models;

import lombok.Getter;
import lombok.Setter;
import pl.filipiak.jakub.vehicleRental.models.helpers.Color;
import pl.filipiak.jakub.vehicleRental.models.helpers.VehicleType;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class Car extends Vehicle {

    private String name;

    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @Enumerated(EnumType.STRING)
    private Color color;

    private LocalDate productionDate;

    private Car() {} // for Hibernate

    public Car(String name, Color color, LocalDate productionDate) {
        super();
        super.setType(VehicleType.CAR);
        this.name = name;
        this.color = color;
        this.productionDate = productionDate;
    }

    public Car(Long id, String name, Color color, LocalDate productionDate) {
        super();
        super.setType(VehicleType.CAR);
        super.setId(id);
        this.name = name;
        this.color = color;
        this.productionDate = productionDate;
    }
}
