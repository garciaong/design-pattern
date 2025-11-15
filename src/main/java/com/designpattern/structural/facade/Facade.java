package com.designpattern.structural.facade;

/**
* Centralized place to all logic and encapsulate all the libraries and functions
*/
public class Facade {
    public static void main(String[] args) {
        PaymentFacade payment = new PaymentFacade();
        payment.transfer("USD", 100);
        payment.transfer("USD", 1000);
    }
}

class PaymentFacade {
    private AccountService service = new AccountService();
    public void transfer(String currency, double amount) {
        Account account = service.getAccount("moneygrab");
        if(amount > account.amount) {
            System.out.println("Transfer failed! => Insufficient fund");
        } else {
            System.out.println("Transfer success!");
        }

    }
}

class AccountService {
    public Account getAccount(String username) {
        return new Account(username, 100);
    } 
}

class Account {
    String username;
    double amount;
    
    Account(String username, double amount){
        this.username = username;
        this.amount = amount;
    }
}
