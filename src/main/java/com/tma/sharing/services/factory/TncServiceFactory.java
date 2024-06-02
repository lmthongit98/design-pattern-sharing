package com.tma.sharing.services.factory;

import com.tma.sharing.services.tnc.TncService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TncServiceFactory {

    private final Map<String, TncService> lenderTncServiceMap;

    public TncServiceFactory(List<TncService> tncServices) {
        this.lenderTncServiceMap = tncServices.stream().collect(Collectors.toMap(TncService::getLender, Function.identity()));
    }

    public TncService getTncService(String lender) {
        return lenderTncServiceMap.get(lender);
    }

}
