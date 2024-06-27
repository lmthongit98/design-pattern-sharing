package com.tma.sharing.casestudies.tnc.services.tnc;

import com.tma.sharing.casestudies.tnc.services.api.impl.BomApiCalling;
import com.tma.sharing.casestudies.tnc.services.factory.OutstandingResolverFactory;

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
