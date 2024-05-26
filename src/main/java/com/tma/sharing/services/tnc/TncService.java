package com.tma.sharing.services.tnc;

public abstract class TncService {

    protected Double getOutstandingAmount(String applicationId, String lenderToBeSent) {
        return 0.0;
    }

    protected void validateLenderToBeSent(String applicationId, String lenderToBeSent) {
        System.out.format("Check if the lenderToBeSent %s is a valid lender identified by rule engine \n", lenderToBeSent);
    }

    protected void checkRenewalCase(String applicationId, String lenderToBeSent) {
        System.out.println("If the application is a renewal case, then we need to handle proper business logic for it");
        Double outstandingAmount = getOutstandingAmount(applicationId, lenderToBeSent);
        if (outstandingAmount > 0) {
            // do somethings
        } else {
            // do somethings
        }
    }

    public abstract void sendTnc(String applicationId, String lenderToBeSent);

}
