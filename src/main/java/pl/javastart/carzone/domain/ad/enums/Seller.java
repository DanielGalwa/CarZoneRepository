package pl.javastart.carzone.domain.ad.enums;

public enum Seller {
    PRYWATNY("Osoba prywtna"),
    FIRMA("Firma");
    private final String name;

    Seller(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
