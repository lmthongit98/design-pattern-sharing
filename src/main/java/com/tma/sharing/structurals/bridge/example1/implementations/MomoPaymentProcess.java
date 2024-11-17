package com.tma.sharing.structurals.bridge.example1.implementations;

public class MomoPaymentProcess implements PaymentProcess {
    private final String phoneNumber;

    public MomoPaymentProcess(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " VND with momo card " + phoneNumber);
    }
}
