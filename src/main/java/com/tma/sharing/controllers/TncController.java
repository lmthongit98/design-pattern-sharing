package com.tma.sharing.controllers;

import com.tma.sharing.services.tnc.AbflTncService;
import com.tma.sharing.services.tnc.TncService;

public class TncController {

    // api/v1/send-tnc/{applicationId}{lender}
    public void sendTnc(String applicationId, String lender) {
        TncService tncService = new AbflTncService();
        tncService.sendTnc(applicationId, lender);
    }

}
