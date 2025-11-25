package com.designpattern.behavioural.strategy;

/**
 * Design pattern that enables selecting an algorithm or behavior at runtime. It defines a 
 * family of algorithms, encapsulates each one into a separate class, and makes them 
 * interchangeable, allowing the client to choose and switch between strategies dynamically.
 */
public class Strategy {
    public static void main(String[] args) {
        PaymentService payment = new PaymentService(new PayPalPayment());
        payment.processPayment();
        payment = new PaymentService(new CreditCardPayment());
        payment.processPayment();
    }
}

class PaymentService {
    private PaymentStrategy strategy;
    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment() {
        System.out.println("Is verified payment? "+strategy.verifyPayment());
        strategy.makePayment();
    }
}

interface PaymentStrategy {
    boolean verifyPayment();

    void makePayment();
}

class PayPalPayment implements PaymentStrategy {

    @Override
    public boolean verifyPayment() {
        return true;    
    }

    @Override
    public void makePayment() {
        System.out.println("PayPal payment made.");    
    }
    
}

class CreditCardPayment implements PaymentStrategy {

    @Override
    public boolean verifyPayment() {
        return true;    
    }

    @Override
    public void makePayment() {
        System.out.println("Credit Card payment made.");    
    }
    
}