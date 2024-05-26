package com.tma.sharing.services.tnc;

import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public abstract class TncService {

    private final OutstandingAmountResolver outstandingAmountResolver;

    protected TncService(OutstandingAmountResolver outstandingAmountResolver) {
        this.outstandingAmountResolver = outstandingAmountResolver;
    }

    protected Double getOutstandingAmount(String applicationId, String lenderToBeSent) {
        return outstandingAmountResolver.getOutstandingAmount(applicationId, lenderToBeSent);
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
