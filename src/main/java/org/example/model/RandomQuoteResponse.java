package org.example.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Quote;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Random;

public class RandomQuoteResponse {
    HttpClient clientQuote = HttpClient.newHttpClient();
    HttpRequest quote = HttpRequest.newBuilder(
            URI.create("https://zenquotes.io/api/random"))
            .header("accept", "application/json")
                .build();
    public void getQuoteResponse() throws IOException, InterruptedException {
        //for the event API create a function with two parameters which takes day and month from the user input
        HttpResponse<String> responseQuote = this.clientQuote.send(this.quote, HttpResponse.BodyHandlers.ofString());

        String jsonStringQuote = responseQuote.body();

        ObjectMapper objectMapperQuote = new ObjectMapper();
        //objectMapperQuote.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<Quote> q=objectMapperQuote.readValue(jsonStringQuote, new TypeReference<List<Quote>>(){});

        //System.out.println("url: " + quote);

        System.out.println(q.get(0).getQuote()+" " + q.get(0).getAuthor());
    }


        // to avoid mistakes if the internet connection is unstable or API is not working






}
