package pl.javastart.carzone.domain.ad.enums;

public enum Gearbox {
    AUTOMATYCZNA("automatyczna"),
    MANUALNA("manualna");
    private final String name;

    Gearbox(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
