package com.tma.sharing.controllers;

import com.tma.sharing.services.api.impl.AbflApiCalling;
import com.tma.sharing.services.outstanding.OutstandingAmountResolver;
import com.tma.sharing.services.outstanding.impl.InternalApiResolver;
import com.tma.sharing.services.outstanding.impl.LenderApiResolver;
import com.tma.sharing.services.tnc.AbflTncService;
import com.tma.sharing.services.tnc.TncService;

import java.util.List;

public class TncController {

    // api/v1/send-tnc/{applicationId}{lender}
    public void sendTnc(String applicationId, String lender) {
        OutstandingAmountResolver outstandingAmountResolver = null;
        if (List.of("ABFL", "PNB").contains(lender)) {
            outstandingAmountResolver = new InternalApiResolver();
        } else if (List.of("BOM", "IDFC").contains(lender)) {
            outstandingAmountResolver = new LenderApiResolver();
        }
        TncService tncService = new AbflTncService(outstandingAmountResolver, new AbflApiCalling());
        tncService.sendTnc(applicationId, lender);
    }

}
