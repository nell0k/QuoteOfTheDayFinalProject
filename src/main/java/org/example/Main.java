package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // create a client
        HttpClient client = HttpClient.newHttpClient();

        // create a request
        HttpRequest programmingQuoteRequest = HttpRequest.newBuilder(
                        URI.create("https://zenquotes.io/api/random"))
                .header("accept", "application/json")
                .build();


        try {
            // to avoid mistakes if the internet connection is unstable or API is not working
            HttpResponse<String> response = client.send(programmingQuoteRequest, HttpResponse.BodyHandlers.ofString());

            String jsonString = response.body();

            ObjectMapper objectMapper = new ObjectMapper();

            List<Quote> quote =  objectMapper.readValue(jsonString, new TypeReference<List<Quote>>(){});
            //pass in the list


            System.out.println("url: " + quote);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");

        }
    }
}
