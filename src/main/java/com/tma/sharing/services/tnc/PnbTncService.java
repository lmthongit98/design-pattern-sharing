package com.tma.sharing.services.tnc;

import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class PnbTncService extends TncService {

    public PnbTncService(OutstandingAmountResolver outstandingAmountResolver) {
        super(outstandingAmountResolver);
    }

    @Override
    public void sendTnc(String applicationId, String lenderToBeSent) {
        validateLenderToBeSent(applicationId, lenderToBeSent);
        checkRenewalCase(applicationId, lenderToBeSent);
        // logic call api to lender
        System.out.println("Call PNB API");
    }

}
