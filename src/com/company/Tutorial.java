package com.company;

/**
 * Created by NikolaiSmotritsky on 6/14/2016.
 */
import java.net.*;
import java.io.*;

public class Tutorial {
//    following the tutorial on http://tutorials.jenkov.com/java-networking/sockets.html
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://jenkov.com");

        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        InputStream input = urlConnection.getInputStream();

        int data = input.read();
        while(data != -1){
            System.out.print((char) data);
            data = input.read();
        }
        input.close();
    }
}
