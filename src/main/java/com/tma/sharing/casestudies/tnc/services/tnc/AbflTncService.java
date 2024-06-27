package com.tma.sharing.casestudies.tnc.services.tnc;

import com.tma.sharing.casestudies.tnc.services.api.impl.AbflApiCalling;
import com.tma.sharing.casestudies.tnc.services.factory.OutstandingResolverFactory;
import com.tma.sharing.casestudies.tnc.services.outstanding.OutstandingAmountResolver;

public class AbflTncService extends TncService {

    public AbflTncService(OutstandingResolverFactory outstandingResolverFactory, AbflApiCalling abflApiCalling) {
        super(outstandingResolverFactory, abflApiCalling);
    }

    @Override
    public void callLenderApi(String applicationId) {
        lenderApiCalling.callLenderApi(applicationId);
    }

    @Override
    public String getLender() {
        return "ABFL";
    }

}
