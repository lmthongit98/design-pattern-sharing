package com.tma.sharing.creationals.factorymethod;

public class Client {

    public static void main(String[] args) {

        BillAmountCalculator billAmountCalculator = new InstitutionPlanCalculator();
        int units = 2;
        System.out.print("Bill amount for " + billAmountCalculator.getPlanType() + " of  " + units + " units is: " + billAmountCalculator.getBillAmount(units));

    }
}
