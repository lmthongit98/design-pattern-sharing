package com.tma.sharing.casestudies.tnc.services.outstanding;

import java.util.List;

public interface OutstandingAmountResolver {
    Double getOutstandingAmount(String applicationId, String lender);
    List<String> getApplicableLenders();
}
