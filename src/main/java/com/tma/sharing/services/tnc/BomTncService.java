package com.tma.sharing.services.tnc;

import com.tma.sharing.services.api.impl.BomApiCalling;
import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class BomTncService extends TncService {

    public BomTncService(OutstandingAmountResolver outstandingAmountResolver, BomApiCalling bomApiCalling) {
        super(outstandingAmountResolver, bomApiCalling);
    }

    @Override
    public void callLenderApi(String applicationId) {
        lenderApiCalling.callLenderApi(applicationId);
    }

}
