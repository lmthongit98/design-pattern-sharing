# Non-Banking Financial System (NBFS)

## Project Overview

The Non-Banking Financial System (NBFS) is designed to support Small and Medium-sized Enterprises (SMPs) in applying for bank loans. The system connects them with various lenders (e.g., ABFL, IDFC). This project focuses on a co-lending flow, which processes loan applications through multiple stages before the loan amount can be disbursed.



## Business flow

Co-lending flow includes 3 stages:
- **Term stage:** Send TnC (terms and conditions accepted by customer) to an eligible co-lender. After sending, the application of the customer will be managed in a co-lender dashboard, then the lender will review to accept or reject the term.
- **Agreement stage.**
- **Disbursal stage.**

## Design the **sendTnc** Flow

![](/Users/lminhthong/Workspace/Design_Patterns-Tnc-Sequence.drawio.png)


## Design Patterns Used

### Factory Pattern
The `OutstandingResolverFactory` and `TncServiceFactory` classes are examples of the Factory Pattern, which helps in creating objects without exposing the instantiation logic to the client.

### Strategy Pattern
The `LenderApiCalling` interface and its implementations (`PnbApiCalling`, `IdfcApiCalling`, etc.) demonstrate the Strategy Pattern, allowing the algorithm to vary independently from clients that use it.

### Template Method Pattern
The `TncService` class uses the Template Method Pattern, defining the skeleton of an algorithm and allowing subclasses to define certain steps of the algorithm without changing its structure.

### Bridge Pattern
The separation of `OutstandingAmountResolver` and `LenderApiCalling` interfaces from their concrete implementations allows varying the interface and implementation independently, demonstrating the Bridge Pattern.