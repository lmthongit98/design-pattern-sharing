package com.tma.sharing.services.tnc;

import com.tma.sharing.services.api.impl.AbflApiCalling;
import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class  AbflTncService extends TncService {

    public AbflTncService(OutstandingAmountResolver outstandingAmountResolver, AbflApiCalling abflApiCalling) {
        super(outstandingAmountResolver, abflApiCalling);
    }

    @Override
    public void callLenderApi(String applicationId) {
        lenderApiCalling.callLenderApi(applicationId);
    }

}
