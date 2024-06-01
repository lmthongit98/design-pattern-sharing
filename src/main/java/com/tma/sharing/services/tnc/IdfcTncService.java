package com.tma.sharing.services.tnc;

import com.tma.sharing.services.api.impl.IdfcApiCalling;
import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class IdfcTncService extends TncService {

    public IdfcTncService(OutstandingAmountResolver outstandingAmountResolver, IdfcApiCalling idfcApiCalling) {
        super(outstandingAmountResolver, idfcApiCalling);
    }

    @Override
    public void callLenderApi(String applicationId) {
        lenderApiCalling.callLenderApi(applicationId);
    }

}
