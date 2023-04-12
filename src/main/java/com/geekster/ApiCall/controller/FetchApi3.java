package com.geekster.ApiCall.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class FetchApi3 {
    public static void main(String[] args) {
        try {
            // Set the API endpoint URL
            URL url = new URL("https://api.nationalize.io/?name=nathaniel");

            // Open a connection to the API endpoint
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Check the response code
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // If the response code is OK, read the response body
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print the JSON response data
                System.out.println(response.toString());
            } else {
                // If the response code is not OK, print the error message
                System.out.println("HTTP error code: " + responseCode);
            }
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        }
    }
}
