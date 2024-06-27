package com.tma.sharing.casestudies.tnc.services.api.impl;

import com.tma.sharing.casestudies.tnc.services.api.LenderApiCalling;

public class PnbApiCalling implements LenderApiCalling {
    @Override
    public void callLenderApi(String application) {
        System.out.println("Call PNB API");
    }
}
