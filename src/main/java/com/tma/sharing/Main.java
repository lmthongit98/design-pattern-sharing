package com.tma.sharing;

import com.tma.sharing.controllers.TncController;

public class Main {

    public static void main(String[] args) {

        // input from user
        String lender = "ABFL";
        String applicationId = "123456";


        TncController tncController = new TncController();
        tncController.sendTnc(applicationId, lender);
    }

}
