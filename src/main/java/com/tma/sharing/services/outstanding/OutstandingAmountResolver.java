package com.tma.sharing.services.outstanding;

public interface OutstandingAmountResolver {
    Double getOutstandingAmount(String applicationId, String lender);
}
