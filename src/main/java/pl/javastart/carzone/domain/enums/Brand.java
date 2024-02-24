package pl.javastart.carzone.domain.enums;

public enum Brand {
    BMW("BMW", new String[]{"Model1", "Model2", "Model3"}),
    AUDI("Audi", new String[]{"Model1", "Model2", "Model3"}),
    MERCEDES("Mercedes", new String[]{"Model1", "Model2", "Model3"});
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