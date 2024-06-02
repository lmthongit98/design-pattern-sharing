package com.tma.sharing.services.tnc;

import com.tma.sharing.services.api.impl.IdfcApiCalling;
import com.tma.sharing.services.factory.OutstandingResolverFactory;

public class IdfcTncService extends TncService {

    public IdfcTncService(OutstandingResolverFactory outstandingResolverFactory, IdfcApiCalling idfcApiCalling) {
        super(outstandingResolverFactory, idfcApiCalling);
    }

    @Override
    public void callLenderApi(String applicationId) {
        lenderApiCalling.callLenderApi(applicationId);
    }

    @Override
    public String getLender() {
        return "IDFC";
    }

}
