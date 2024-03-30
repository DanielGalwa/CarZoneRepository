package pl.javastart.carzone.domain.ad.enums;

public enum VehicleModel {

    A5("A5"),
    A8("A8"),
    A6("A6"),
    M5("M5"),
    M4("M4");

    private final String name;

    VehicleModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
