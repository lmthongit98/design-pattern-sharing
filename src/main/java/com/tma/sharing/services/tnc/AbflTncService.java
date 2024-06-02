package com.tma.sharing.services.tnc;

import com.tma.sharing.services.api.impl.AbflApiCalling;
import com.tma.sharing.services.factory.OutstandingResolverFactory;
import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

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
