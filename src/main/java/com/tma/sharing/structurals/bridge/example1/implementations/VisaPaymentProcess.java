package com.tma.sharing.structurals.bridge.example1.implementations;

public class VisaPaymentProcess implements PaymentProcess {
    private final String cardNumber;

    public VisaPaymentProcess(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " VND with visa card " + cardNumber);
    }
}
