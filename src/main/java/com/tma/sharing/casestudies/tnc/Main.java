package com.tma.sharing.casestudies.tnc;

import com.tma.sharing.casestudies.tnc.controllers.TncController;
import com.tma.sharing.casestudies.tnc.services.api.impl.AbflApiCalling;
import com.tma.sharing.casestudies.tnc.services.api.impl.PnbApiCalling;
import com.tma.sharing.casestudies.tnc.services.factory.OutstandingResolverFactory;
import com.tma.sharing.casestudies.tnc.services.factory.TncServiceFactory;
import com.tma.sharing.casestudies.tnc.services.outstanding.impl.InternalApiResolver;
import com.tma.sharing.casestudies.tnc.services.outstanding.impl.LenderApiResolver;
import com.tma.sharing.casestudies.tnc.services.tnc.AbflTncService;
import com.tma.sharing.casestudies.tnc.services.tnc.PnbTncService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // input from user
        String lender = "ABFL";
        String applicationId = "123456";

        // Setup DI
        OutstandingResolverFactory outstandingResolverFactory = new OutstandingResolverFactory(List.of(new InternalApiResolver(), new LenderApiResolver()));

        AbflTncService abflTncService = new AbflTncService(outstandingResolverFactory, new AbflApiCalling());
        PnbTncService pnbTncService = new PnbTncService(outstandingResolverFactory, new PnbApiCalling());

        TncServiceFactory tncServiceFactory = new TncServiceFactory(List.of(abflTncService, pnbTncService));

        TncController tncController = new TncController(tncServiceFactory);

        // trigger sendTnc flow
        tncController.sendTnc(applicationId, lender);
    }

}
