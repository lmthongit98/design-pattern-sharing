package com.tma.sharing.services.api.impl;

import com.tma.sharing.services.api.LenderApiCalling;

public class AbflApiCalling implements LenderApiCalling {
    @Override
    public void callLenderApi(String application) {
        System.out.println("Call ABFL API");
    }
}
