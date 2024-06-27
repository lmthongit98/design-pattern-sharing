package com.tma.sharing.casestudies.tnc.services.api.impl;

import com.tma.sharing.casestudies.tnc.services.api.LenderApiCalling;

public class BomApiCalling implements LenderApiCalling {
    @Override
    public void callLenderApi(String application) {
        System.out.println("Call BOM API");
    }
}
