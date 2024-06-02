package com.tma.sharing.services.tnc;

import com.tma.sharing.services.api.impl.PnbApiCalling;
import com.tma.sharing.services.factory.OutstandingResolverFactory;

public class PnbTncService extends TncService {

    public PnbTncService(OutstandingResolverFactory outstandingResolverFactory, PnbApiCalling pnbApiCalling) {
        super(outstandingResolverFactory, pnbApiCalling);
    }

    @Override
    public void callLenderApi(String applicationId) {
        lenderApiCalling.callLenderApi(applicationId);
    }

    @Override
    public String getLender() {
        return "PNB";
    }

}
