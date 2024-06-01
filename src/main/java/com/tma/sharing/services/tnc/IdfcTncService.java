package com.tma.sharing.services.tnc;

import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class IdfcTncService extends TncService {

    public IdfcTncService(OutstandingAmountResolver outstandingAmountResolver) {
        super(outstandingAmountResolver);
    }

    @Override
    public void callLenderApi(String applicationId) {
        System.out.println("Call IDFC API");
    }

}
