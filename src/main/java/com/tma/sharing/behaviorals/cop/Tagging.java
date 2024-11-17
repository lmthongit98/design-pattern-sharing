package com.tma.sharing.behaviorals.cop;

import java.util.List;

class LoanRequest {
    private String applicationId;
    private List<String> lenders;

    public LoanRequest(String applicationId, List<String> lenders) {
        this.applicationId = applicationId;
        this.lenders = lenders;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public List<String> getLenders() {
        return lenders;
    }

    public void setLenders(List<String> lenders) {
        this.lenders = lenders;
    }
}

abstract class LoanHandler {
    protected LoanHandler next;

    /**
     * Builds chains of loan handler objects.
     */
    public static LoanHandler link(LoanHandler first, LoanHandler... chain) {
        LoanHandler head = first;
        for (LoanHandler nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * Subclasses will implement this method with concrete handleRequest.
     */
    public abstract boolean handleRequest(LoanRequest request);

    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected boolean checkNext(LoanRequest loanRequest) {
        if (next == null) {
            return true;
        }
        return next.handleRequest(loanRequest);
    }

}

class ValidationHandler extends LoanHandler {

    @Override
    public boolean handleRequest(LoanRequest request) {
        if (isNotValid(request)) {
            throw new IllegalStateException("Validation failed");
        }
        return checkNext(request);
    }

    private boolean isNotValid(LoanRequest loanRequest) {
        if (loanRequest == null) {
            return true;
        }
        if (loanRequest.getApplicationId() == null) {
            return true;
        }
        if (loanRequest.getLenders() == null || loanRequest.getLenders().isEmpty()) {
            return true;
        }
        return false;
    }
}

class CheckEligibleLenders extends LoanHandler {

    @Override
    public boolean handleRequest(LoanRequest request) {
        if (!areLendersEligible(request)) {
            throw new RuntimeException("Lenders are not valid");
        }
        return checkNext(request);
    }

    private boolean areLendersEligible(LoanRequest request) {
        List<String> eligibleLenders = findEligibleLendersByApplicationId(request.getApplicationId());
        List<String> filteredLenders = request.getLenders().stream().filter(eligibleLenders::contains).toList();
        request.setLenders(filteredLenders);
        return !filteredLenders.isEmpty();
    }

    private List<String> findEligibleLendersByApplicationId(String applicationId) {
        return List.of("BIDV", "SCB", "KBTG");
    }
}

class LenderApiCalling extends LoanHandler {

    @Override
    public boolean handleRequest(LoanRequest request) {
        for (String lender : request.getLenders()) {
            if (callApiToLender(lender)) {
                break;
            }
        }
        return checkNext(request);
    }

    private boolean callApiToLender(String lender) {
        System.out.println("Call Api To Lender " + lender);
        return true;
    }
}


public class Tagging {
    public static void main(String[] args) {
        LoanHandler loanHandler = LoanHandler.link(
                new ValidationHandler(),
                new CheckEligibleLenders(),
                new LenderApiCalling()
        );
        loanHandler.handleRequest(new LoanRequest("LAI-123", List.of("KBTG")));
    }
}


