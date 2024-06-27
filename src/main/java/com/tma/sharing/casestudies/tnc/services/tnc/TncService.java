package com.tma.sharing.casestudies.tnc.services.tnc;

import com.tma.sharing.casestudies.tnc.services.api.LenderApiCalling;
import com.tma.sharing.casestudies.tnc.services.factory.OutstandingResolverFactory;
import com.tma.sharing.casestudies.tnc.services.outstanding.OutstandingAmountResolver;

public abstract class TncService {

    private final OutstandingAmountResolver outstandingAmountResolver;
    protected final LenderApiCalling lenderApiCalling;

    protected TncService(OutstandingResolverFactory outstandingResolverFactory, LenderApiCalling lenderApiCalling) {
        this.outstandingAmountResolver = outstandingResolverFactory.getOutstandingAmountResolver(getLender());
        this.lenderApiCalling = lenderApiCalling;
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

    public void sendTnc(String applicationId, String lenderToBeSent) {
        validateLenderToBeSent(applicationId, lenderToBeSent);
        checkRenewalCase(applicationId, lenderToBeSent);
        callLenderApi(applicationId);
    }

    protected abstract void callLenderApi(String applicationId);

    public abstract String getLender();

}
