package com.tma.sharing.creationals.factorymethod;

public class InstitutionPlanCalculator extends BillAmountCalculator{
    @Override
    public Plan createPlan() {
        return new InstitutionalPlan();
    }

    @Override
    public String getPlanType() {
        return "Institution";
    }
}
