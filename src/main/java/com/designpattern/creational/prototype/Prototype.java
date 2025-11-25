package com.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Design pattern that enables the creation of new objects by copying an existing object, 
 * referred to as the "prototype." This approach is particularly useful when object creation 
 * is complex, time-consuming, or resource-intensive, or when the system needs to create 
 * objects without knowing their concrete classes.
 * Delegate object duplication or cloning to actual object being cloned 
 */
public class Prototype {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Sedan("Tesla", "Model 3"));
        vehicles.add(new SUV("Tesla", "Model Y"));

        List<Vehicle> vehicleCopies = new ArrayList<>();

        for(Vehicle vehicle:vehicles) {
            vehicleCopies.add(vehicle.clone());
        }

        vehicleCopies.forEach(vehicle -> System.out.println(String.format("Brand %s, model %s", vehicle.getBrand(), vehicle.getModel())));
    }
}

abstract class Vehicle {
    protected String brand;
    protected String model;

    Vehicle(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    };

    public String getModel() {
        return model;
    };

    public abstract Vehicle clone();
}

class Sedan extends Vehicle {
    Sedan(String brand, String model) {
        super(brand, model);
    }

    @Override
    public Vehicle clone() {
        return new Sedan(this.brand, this.model);
    }
}

class SUV extends Vehicle {
    SUV(String brand, String model) {
        super(brand, model);
    }

    @Override
    public Vehicle clone() {
        return new SUV(this.brand, this.model);
    }
}
