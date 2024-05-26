package com.tma.sharing.services.outstanding.impl;

import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

public class InternalApiResolver implements OutstandingAmountResolver {
    @Override
    public Double getOutstandingAmount(String applicationId, String lender) {
        System.out.format("Get outstanding amount for applicationId %s from Internal API \n", applicationId);
        return 0.0;
    }
}
