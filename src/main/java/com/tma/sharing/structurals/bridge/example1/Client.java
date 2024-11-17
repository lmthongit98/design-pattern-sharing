package com.tma.sharing.structurals.bridge.example1;

import com.tma.sharing.structurals.bridge.example1.abstractions.BasicMemberRegistration;
import com.tma.sharing.structurals.bridge.example1.abstractions.MemberRegistration;
import com.tma.sharing.structurals.bridge.example1.abstractions.VipMemberMemberRegistration;
import com.tma.sharing.structurals.bridge.example1.implementations.MomoPaymentProcess;
import com.tma.sharing.structurals.bridge.example1.implementations.PaymentProcess;
import com.tma.sharing.structurals.bridge.example1.implementations.VisaPaymentProcess;

public class Client {

    public static void main(String[] args) {
        PaymentProcess momoPaymentProcess = new MomoPaymentProcess("0363898771");
        MemberRegistration vipMemberMemberRegistration = new VipMemberMemberRegistration(momoPaymentProcess);
        vipMemberMemberRegistration.register();

        PaymentProcess visaPaymentProcess = new VisaPaymentProcess("13579");
        MemberRegistration basicMemberRegistration = new BasicMemberRegistration(visaPaymentProcess);
        basicMemberRegistration.register();
    }

}
