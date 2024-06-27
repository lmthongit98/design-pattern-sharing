package com.tma.sharing.casestudies.tnc.services.outstanding.impl;

import com.tma.sharing.casestudies.tnc.services.outstanding.OutstandingAmountResolver;

import java.util.List;

public class LenderApiResolver implements OutstandingAmountResolver {
    @Override
    public Double getOutstandingAmount(String applicationId, String lender) {
        System.out.format("Get outstanding amount for applicationId %s from Lender API \n", applicationId);
        return 0.0;
    }

    @Override
    public List<String> getApplicableLenders() {
        return List.of("ABFL", "IDFC");
    }
}
