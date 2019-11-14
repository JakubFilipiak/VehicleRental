package pl.filipiak.jakub.vehicleRental.models.helpers;

public enum VehicleType {

    CAR("Car"),
    BIKE("Bike");

    private String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getStringValue() {
        return type;
    }
}
