package com.tma.sharing.casestudies.tnc.controllers;

import com.tma.sharing.casestudies.tnc.services.factory.TncServiceFactory;
import com.tma.sharing.casestudies.tnc.services.tnc.TncService;

public class TncController {

    private final TncServiceFactory tncServiceFactory;

    public TncController(TncServiceFactory tncServiceFactory) {
        this.tncServiceFactory = tncServiceFactory;
    }

    // api/v1/send-tnc/{applicationId}{lender}
    public void sendTnc(String applicationId, String lender) {
        TncService tncService = tncServiceFactory.getTncService(lender);
        tncService.sendTnc(applicationId, lender);
    }

}
