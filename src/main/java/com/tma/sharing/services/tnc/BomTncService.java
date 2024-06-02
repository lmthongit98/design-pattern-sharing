package com.tma.sharing.services.tnc;

import com.tma.sharing.services.api.impl.BomApiCalling;
import com.tma.sharing.services.factory.OutstandingResolverFactory;

public class BomTncService extends TncService {

    public BomTncService(OutstandingResolverFactory outstandingResolverFactory, BomApiCalling bomApiCalling) {
        super(outstandingResolverFactory, bomApiCalling);
    }

    @Override
    public void callLenderApi(String applicationId) {
        lenderApiCalling.callLenderApi(applicationId);
    }

    @Override
    public String getLender() {
        return "BOM";
    }

}
