package com.company;

import javax.microedition.io.*;
import javax.wireless.messaging.*;


public class SMSSender {

    void sendSMSMessage(String message) {
        try
        {
            String addr = "sms://+358401234567";
            MessageConnection conn =
                    (MessageConnection) Connector.open (addr);
            TextMessage msg =
                    (TextMessage)conn.newMessage
                            (MessageConnection.TEXT_MESSAGE);
            msg.setPayloadText ("Hello World!");
            conn.send (msg);
        }
        catch (Exception e) {}
    }
}
