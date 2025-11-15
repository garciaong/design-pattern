package com.designpattern.creational.singleton;

public class Singleton {
    public static void main(String[] args) {
        Service.getInstance();
        Service.getInstance();
        Service.getInstance();
    }
}

class Service {
    /**
     * Any changes made to a volatile variable by one thread are immediately visible 
     * to all other threads
     */
    private static volatile Service instance;
    
    private Service() {
    }
    
    public static Service getInstance() {
        if(instance == null) {
            synchronized(Service.class) {
                if(instance == null) {
                    System.out.println("Service initialization...");
                    instance = new Service();
                }
            }
        }
        
        return instance;
    }
}
