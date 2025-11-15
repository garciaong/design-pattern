package com.designpattern.structural.bridge;

public class Bridge {
    public static void main(String[] args) {
        Restaurant restaurant = new ChineseRestaurant(new FriedRice());
        restaurant.serving();
        restaurant = new ItalianRestaurant(new Pizza());
        restaurant.serving();
    }
}

interface Restaurant {
    void serving();
}

class ItalianRestaurant implements Restaurant {
    private Dish dish;

    public ItalianRestaurant(Dish dish) {
        this.dish = dish;
    }

    @Override
    public void serving() {
        System.out.println("Italian chef serving " + dish.getType());    
    }  
}

class ChineseRestaurant implements Restaurant {
    private Dish dish;

    public ChineseRestaurant(Dish dish) {
        this.dish = dish;
    }

    @Override
    public void serving() {
        System.out.println("Chinese chef serving " + dish.getType());    
    }  
}

interface Dish {
    public String getType();
}

class Pizza implements Dish {
    @Override
    public String getType() {
        return "Pizza";
    }
}

class FriedRice implements Dish {
    @Override
    public String getType() {
        return "Fried Rice";
    }
}