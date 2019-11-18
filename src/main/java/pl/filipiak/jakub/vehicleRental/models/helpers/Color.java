package pl.filipiak.jakub.vehicleRental.models.helpers;

public enum Color {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    OTHER("Other");

    private String textValue;

    Color(String textValue) {
        this.textValue = textValue;
    }

    public String getStringValue() {
        return textValue;
    }

    public static Color fromString(String textValue) {
        for (Color color : Color.values()) {
            if (color.textValue.equals(textValue)) return color;
        }
        return OTHER;
    }
}
