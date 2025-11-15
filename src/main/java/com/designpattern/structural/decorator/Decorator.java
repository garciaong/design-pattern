package com.designpattern.structural.decorator;

/**
 * Attached new behaviors into an object with wrapper
 */
public class Decorator {
    public static void main(String[] args) {
        Notification notification = new EmailNotification(new SMSNotification(new NofificationInit()));
        notification.sendNotification();
    }
}

interface Notification {
    public void sendNotification();
}

class NofificationInit implements Notification {
    NofificationInit() {
        System.out.println("Initializing notification service");
    }
    @Override
    public void sendNotification() {
        System.out.println("Preparing notification service");
    }
}

class BaseNotification implements Notification {
    private final Notification notification;

    public BaseNotification(Notification notification) {
        this.notification = notification;
    }

    public void sendNotification() {
        notification.sendNotification();
    }
}

class EmailNotification extends BaseNotification {
    public EmailNotification(Notification notification) {
        super(notification);
    }
    @Override
    public void sendNotification() {
        super.sendNotification();
        System.out.println("Sending email notification...");
        System.out.println("Email notification sent...");
    }
}

class SMSNotification extends BaseNotification {
    public SMSNotification(Notification notification) {
        super(notification);
    }
    @Override
    public void sendNotification() {
        super.sendNotification();
        System.out.println("Sending SMS notification...");
        System.out.println("SMS notification sent...");
    }
}