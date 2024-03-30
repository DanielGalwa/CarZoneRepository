package pl.javastart.carzone.domain.ad.enums;

public enum Brand {
    BMW("BMW"),
    AUDI("Audi"),
    MERCEDES("Mercedes");


    private final String name;

    public String getName(){
        return name;
    }

    Brand(String name) {
        this.name = name;
    }

}