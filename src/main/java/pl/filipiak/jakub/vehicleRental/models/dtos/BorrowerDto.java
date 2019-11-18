package pl.filipiak.jakub.vehicleRental.models.dtos;

public class BorrowerDto {

    private long id;
    private String name;

    public BorrowerDto(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
