package pl.javastart.carzone.domain.ad.enums;

public enum Brand {
    BMW("BMW", new String[]{"Seria 5", "Seria 3", "Seria 8"}),
    AUDI("Audi", new String[]{"A8", "A5", "A3"}),
    MERCEDES("Mercedes", new String[]{"S klasa", "C klasa", "A klasa"});
    // ... pozostałe marki

    private final String[] models;
    private final String name;

    public String getName(){
        return name;
    }

    Brand(String name,String[] models) {
        this.name = name;
        this.models = models;
    }

    public String[] getModels() {
        return models;
    }
}