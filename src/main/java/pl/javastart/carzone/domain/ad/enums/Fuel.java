package pl.javastart.carzone.domain.ad.enums;

public enum Fuel {
    BENZYNA("benzyna"),
    DIESEL("diesel"),
    ELEKTRYCZNY("elektryczny");

    private final String name;

    Fuel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
