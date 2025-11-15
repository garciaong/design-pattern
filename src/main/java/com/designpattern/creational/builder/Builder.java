package com.designpattern.creational.builder;

import com.google.gson.Gson;

public class Builder {
    public static void main(String[] args) {
        Gson gson = new Gson();
        CarBuilder carBuilder = new CarBuilder();
        Car car = carBuilder.setChasisNo("A001")
                    .setEnginePower("140hp")
                    .setTransmissionType("CVT").build();
        System.out.println("Car1 spec "+ gson.toJson(car));
        car = carBuilder.setChasisNo("A002")
                    .setEnginePower("340hp")
                    .setTransmissionType("DCT").build();  
        System.out.println("Car2 spec "+ gson.toJson(car));
    }
}

class CarBuilder {
    private String chasisNo;
    private String enginePower;
    private String transmissionType;
    
    public CarBuilder() {}

    public CarBuilder setChasisNo(String chasisNo) {
        this.chasisNo = chasisNo;
        return this;
    }
    public CarBuilder setEnginePower(String enginePower) {
        this.enginePower = enginePower;
        return this;
    }
    public CarBuilder setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }
    public Car build() {
        return new Car(chasisNo, enginePower, transmissionType);
    }
}

class Car {
    private final String chasisNo;
    private final String enginePower;
    private final String transmissionType;

    public Car(String chasisNo, String enginePower, String transmissionType) {
        this.chasisNo = chasisNo;
        this.enginePower = enginePower;
        this.transmissionType = transmissionType;
    }

    public String getChasisNo() {
        return chasisNo;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public String getTransmissionType() {
        return transmissionType;
    }
}
