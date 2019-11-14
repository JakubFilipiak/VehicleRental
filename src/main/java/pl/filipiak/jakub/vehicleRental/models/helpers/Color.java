package pl.filipiak.jakub.vehicleRental.models.helpers;

public enum Color {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    OTHER("Other");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getStringValue() {
        return color;
    }
}
