package com.tma.sharing.creationals.factorymethod;

public abstract class BillAmountCalculator {

    public abstract Plan createPlan();

    public abstract String getPlanType();

    public double getBillAmount(int units) {
        Plan plan = createPlan();
        return plan.calculateBillAmount(units);
    }

}
