package com.tma.sharing.structurals.bridge.example1.abstractions;

import com.tma.sharing.structurals.bridge.example1.implementations.PaymentProcess;

public class BasicMemberRegistration implements MemberRegistration {

    private final PaymentProcess paymentProcess;

    public BasicMemberRegistration(PaymentProcess paymentProcess) {
        this.paymentProcess = paymentProcess;
    }

    @Override
    public void register() {
        int amount = 50000;
        this.paymentProcess.pay(amount);
        System.out.println("Registered for Youtube membership");
    }
}
