package com.example.testjava.learn;

import com.example.testjava.myInterface.ReceivedDataListener;

public class Internet {

    private ReceivedDataListener listener;

    public void getDataFromMySite(ReceivedDataListener receivedDataListener) {
        listener = receivedDataListener;


        // after 5 minute
        boolean success = true ;

        if (success) {
            listener.ReceivedData("ahmad");
        }else {
            listener.failed();
        }


    }

}
