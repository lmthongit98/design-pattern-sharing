package com.tma.sharing.services.tnc;

public class IdfcTncService extends TncService {

    @Override
    public void sendTnc(String applicationId, String lenderToBeSent) {
        validateLenderToBeSent(applicationId, lenderToBeSent);
        checkRenewalCase(applicationId, lenderToBeSent);
        // logic call api to lender
        System.out.println("Call IDFC API");
    }

}
