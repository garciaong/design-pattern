package com.designpattern.creational.factory;

public class Factory {
    public static void main(String[] args) {
        Restaurant restaurant = new ClassicRestaurantFactory();
        System.out.println(String.format("Restaurant %s is selling %s burger", restaurant.restaurantType(), restaurant.orderBurger().getType()));
        restaurant = new RamliRestaurantFactory();
        System.out.println(String.format("Restaurant %s is selling %s burger", restaurant.restaurantType(), restaurant.orderBurger().getType()));
    }
}

abstract class Restaurant {
    protected String restaurantType;

    public Burger orderBurger() {
        return this.makeBuger();
    }

    abstract String restaurantType();

    abstract Burger makeBuger();
}

class ClassicRestaurantFactory extends Restaurant {
    @Override
    String restaurantType() {
        return "Classic";
    }
    @Override
    Burger makeBuger() {
        return new ClassicBurger();
    }
}

class RamliRestaurantFactory extends Restaurant{
    @Override
    String restaurantType() {
        return "Ramli";
    }
    @Override
    Burger makeBuger() {
        return new RamliBurger();
    }
}

interface Burger {
    String getType();
}

class ClassicBurger implements Burger {
    @Override
    public String getType() {
        return "Classic";
    } 
}

class RamliBurger implements Burger {
    @Override
    public String getType() {
        return "Ramli";
    } 
}