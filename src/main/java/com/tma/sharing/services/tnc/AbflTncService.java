package com.tma.sharing.services.tnc;

import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class AbflTncService extends TncService {

    public AbflTncService(OutstandingAmountResolver outstandingAmountResolver) {
        super(outstandingAmountResolver);
    }

    @Override
    public void callLenderApi(String applicationId) {
        System.out.println("Call ABFL API");
    }

}
