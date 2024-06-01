package com.tma.sharing.services.tnc;

import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class BomTncService extends TncService {

    public BomTncService(OutstandingAmountResolver outstandingAmountResolver) {
        super(outstandingAmountResolver);
    }

    @Override
    public void callLenderApi(String applicationId) {
        System.out.println("Call BOM API");
    }

}
