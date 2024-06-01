package com.tma.sharing.services.tnc;

import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class PnbTncService extends TncService {

    public PnbTncService(OutstandingAmountResolver outstandingAmountResolver) {
        super(outstandingAmountResolver);
    }

    @Override
    public void callLenderApi(String applicationId) {
        System.out.println("Call PNB API");
    }

}
