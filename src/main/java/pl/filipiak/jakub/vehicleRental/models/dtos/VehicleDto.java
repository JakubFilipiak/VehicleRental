package pl.filipiak.jakub.vehicleRental.models.dtos;

public class VehicleDto {

    private long id;
    private String type;
    private String nameOrNumber;
    private String producerName;
    private String color;
    private String productionDate;

    private long borrowId;
    private String borrowDate;

    private long borrowerId;
    private String borrowerName;
}
