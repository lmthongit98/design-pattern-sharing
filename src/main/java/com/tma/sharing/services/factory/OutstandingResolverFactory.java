package com.tma.sharing.services.factory;

import com.tma.sharing.services.outstanding.OutstandingAmountResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutstandingResolverFactory {

    private final Map<String, OutstandingAmountResolver> lenderOutstandingResolverMap = new HashMap<>();

    public OutstandingResolverFactory(List<OutstandingAmountResolver> outstandingAmountResolvers) {
        for (OutstandingAmountResolver outstandingAmountResolver : outstandingAmountResolvers) {
            for (String lender : outstandingAmountResolver.getApplicableLenders()) {
                lenderOutstandingResolverMap.put(lender, outstandingAmountResolver);
            }
        }
    }

    public OutstandingAmountResolver getOutstandingAmountResolver(String lender) {
        return lenderOutstandingResolverMap.get(lender);
    }

}
