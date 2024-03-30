package pl.javastart.carzone.domain.ad.enums;

public enum BodyType {
    SEDAN("sedan"),
    COUPE("coupe"),
    HATCHBACK("hatchback");

    private final String name;

    BodyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
