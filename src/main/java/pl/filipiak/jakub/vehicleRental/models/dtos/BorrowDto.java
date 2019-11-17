package pl.filipiak.jakub.vehicleRental.models.dtos;

public class BorrowDto {

    private long id;
    private String date;

    private long vehicleId;
    private String vehicleType;
    private String vehicleNameOrNumber;
    private String vehicleProducerName;
    private String vehicleColor;
    private String vehicleProductionDate;

    private long borrowerId;
    private String borrowerName;
}
