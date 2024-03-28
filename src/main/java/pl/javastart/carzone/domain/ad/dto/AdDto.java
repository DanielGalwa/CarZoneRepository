package pl.javastart.carzone.domain.ad.dto;

public class AdDto {
    private Long id;
    private String vehicleBrand;
    private String vehicleModel;
    private int price;
    private int engineSize;
    private int power;
    private int mileage;
    private String fuelType;
    private String gear;
    private int yearOfProduction;
    private String location;
    private String seller;

    private String picture;

    private String bodyType;

    private String phoneNumber;

    public AdDto(Long id, String vehicleBrand, String vehicleModel, int price, int engineSize, int power, int mileage,
                 String fuelType, String gear, int yearOfProduction, String location, String seller, String picture,String bodyType,String phoneNumber) {
        this.id = id;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.price = price;
        this.engineSize = engineSize;
        this.power = power;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.gear = gear;
        this.yearOfProduction = yearOfProduction;
        this.location = location;
        this.seller = seller;
        this.picture = picture;
        this.bodyType = bodyType;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
