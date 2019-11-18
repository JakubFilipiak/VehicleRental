package pl.filipiak.jakub.vehicleRental.models.dtos;

import lombok.Setter;

public class BorrowDto {

    private long id;
    private String date;

    @Setter
    private BorrowerDto borrowerDto;

    public BorrowDto(long id, String date) {
        this.id = id;
        this.date = date;
    }
}
