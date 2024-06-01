package com.tma.sharing.services.tnc;

import com.tma.sharing.services.api.impl.PnbApiCalling;
import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class PnbTncService extends TncService {

    public PnbTncService(OutstandingAmountResolver outstandingAmountResolver, PnbApiCalling pnbApiCalling) {
        super(outstandingAmountResolver, pnbApiCalling);
    }

    @Override
    public void callLenderApi(String applicationId) {
        lenderApiCalling.callLenderApi(applicationId);
    }

}
