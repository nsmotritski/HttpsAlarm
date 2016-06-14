package com.company;

import org.jsoup.*;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class URLConnectionReader {
    public static void main(String[] args) throws Exception {

        String urlParameters = "__EVENTTARGET=HeaderControlGroupRibbonSelectView_AvailabilitySearchInputRibbonSelectView_ButtonSubmit&__VIEWSTATE=%2FwEPDwUBMGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFXEhlYWRlckNvbnRyb2xHcm91cFJpYmJvblNlbGVjdFZpZXckQXZhaWxhYmlsaXR5U2VhcmNoSW5wdXRSaWJib25TZWxlY3RWaWV3JFN0dWRldFNlbmlvckdyb3VwwAw35gayQedhYJ8oz%2BCHlR8x2gWGvNOEfHfCOBjF%2Flk%3D&23eb7317-e965-4707-9dba-5d8784a604ea=8c2c090a-c3ca-488c-90cb-3f0a2eb77a76&HeaderControlGroupRibbonSelectView%24AvailabilitySearchInputRibbonSelectView%24OriginStation=BCN&HeaderControlGroupRibbonSelectView%24AvailabilitySearchInputRibbonSelectView%24DestinationStation=VNO&HeaderControlGroupRibbonSelectView%24AvailabilitySearchInputRibbonSelectView%24DepartureDate=23.07.2016&HeaderControlGroupRibbonSelectView%24AvailabilitySearchInputRibbonSelectView%24PaxCountADT=1&HeaderControlGroupRibbonSelectView%24AvailabilitySearchInputRibbonSelectView%24PaxCountCHD=0&HeaderControlGroupRibbonSelectView%24AvailabilitySearchInputRibbonSelectView%24PaxCountINFANT=0&WizzSummaryDisplaySelectViewRibbonSelectView%24PaymentCurrencySelector=00000000-0000-0000-0000-000000000000FULL&HeaderControlGroupRibbonSelectView%24AvailabilitySearchInputRibbonSelectView%24ButtonSubmit=%D0%9F%D0%BE%D0%B8%D1%81%D0%BA";
        byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int    postDataLength = postData.length;
        String request        = "https://wizzair.com/ru-RU/Select";
        URL    url            = new URL( request );
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( true );
        conn.setRequestMethod( "POST" );
        conn.setRequestProperty( "Host", "wizzair.com");
        conn.setRequestProperty( "Connection", "keep-alive");
        conn.setRequestProperty( "Content-Length", "" +  urlParameters.length());
        conn.setRequestProperty( "Cache-Control", "max-age=0");
        conn.setRequestProperty( "Origin", "https://wizzair.com");
        conn.setRequestProperty( "Upgrade-Insecure-Requests", "0");
        conn.setRequestProperty( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36");
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,****/*//*//**//*//**//**//**//*;q=0.8");
        conn.setRequestProperty( "Referer", "https://wizzair.com/ru-RU/Select");
        conn.setRequestProperty( "Accept-Language", "it,en-US;q=0.8,en;q=0.6");
        conn.setRequestProperty( "Cookie", "ASP.NET_SessionId=p4k5xzbyg3ce2ozpbtip2tc4; cookie_settings=necessary=1,functionality=1,performance=1,advertising=1; HomePageSelector=FlightSearch; _dc_gtm_UA-2629375-1=1; _gat_UA-2629375-1=1; Culture=ru-RU; cookiesAccepted=true; _ga=GA1.2.1881330064.1455824998; _gali=HeaderControlGroupRibbonSelectView_AvailabilitySearchInputRibbonSelectView_ButtonSubmit");

        conn.setRequestProperty( "charset", "utf-8");
        // Send post request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        System.out.println(conn.getContent());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("Sending 'POST' request to URL : " + url);
        System.out.println(conn.getContent());
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);
        System.out.println("Response Message : " + conn.getResponseMessage());

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
//        Document doc = Jsoup.parse(response.toString());
    }
}