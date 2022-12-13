package org.example;
import java.io.IOException;
import java.util.List;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.example.model.Event;
import org.example.model.InfoDataResponse;

import org.example.model.RandomQuoteResponse;
import org.example.model.UserInputEvent;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//totally forgot where exactly are we using gradle
public class Main {
    public static void main(String[] args) {

        RandomQuoteResponse quoteOfTheDay= new RandomQuoteResponse();
        try {
            quoteOfTheDay.getQuoteResponse();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int day = 0, month = 0;
        UserInputEvent userInput = new UserInputEvent();
        boolean isInputSuccesfull= false;
        while (isInputSuccesfull== false){
            try {
                userInput.takeInput();
                isInputSuccesfull = true;
                //how to use this numbers in the API request to select exactly the same day and months events from the list
            }
            catch(InputMismatchException e){
                System.out.println(e);
                System.out.println("please enter only numbers, no other input allowed");
            }

        }

        // create a client
        HttpClient clientEvent = HttpClient.newHttpClient();
        //do we need second client for the second API?

        // create a request

        HttpRequest programmingEventRequest = HttpRequest.newBuilder(
                        URI.create("https://today.zenquotes.io/api/"+day+"/"+month))
                .header("accept", "application/json")
                .build();

        try {
            // to avoid mistakes if the internet connection is unstable or API is not working
            HttpResponse<String> response = clientEvent.send(programmingEventRequest, HttpResponse.BodyHandlers.ofString());

            String jsonString = response.body();

            ObjectMapper objectMapper = new ObjectMapper();


            InfoDataResponse eventsOfTheDay =  objectMapper.readValue(jsonString, new TypeReference<InfoDataResponse>(){});
            //pass in the list
            List<Event> EventsOfThisDay=eventsOfTheDay.getData().getEvents();
            Random random= new Random();
            Event randomEvent=EventsOfThisDay.get(random.nextInt(EventsOfThisDay.size()));

            //System.out.println("url: " + quote);
            String decodedEvent = StringEscapeUtils.unescapeHtml3(randomEvent.getText());
            System.out.println(decodedEvent);
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error");

        }
    }
}
