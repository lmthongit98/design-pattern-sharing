package com.tma.sharing.creationals.factorymethod;

public class CommercialPlanCalculator extends BillAmountCalculator{
    @Override
    public Plan createPlan() {
        return new CommercialPlan();
    }

    @Override
    public String getPlanType() {
        return "Commercial";
    }
}
