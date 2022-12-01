package org.example;
import java.util.List;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.example.model.Event;
import org.example.model.InfoDataResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //user input current day and month to see the random event which was happening on the same date another year
        Scanner userInputDay=new Scanner(System.in);
        //add try catch in case of the wrong input type from the user
        System.out.println("Please type what day is today");
        Integer day=userInputDay.nextInt();
        Scanner userInputMonth=new Scanner(System.in);
        System.out.println("Please type what month is today");
        Integer month= userInputMonth.nextInt();
        //how to use this numbers in the API request to select exactly the same day and months events from the list



        // create a client
        HttpClient client = HttpClient.newHttpClient();

        // create a request
        HttpRequest programmingQuoteRequest = HttpRequest.newBuilder(
                        URI.create("https://zenquotes.io/api/random"))
                .header("accept", "application/json")
                .build();
    //Request Quotes from a Specific Author
        // how to display list of the available authors with the link? create a arraylist?[quotes]/[author]?[random]/[author]?
        HttpRequest programmingEventRequest = HttpRequest.newBuilder(
                        URI.create("https://today.zenquotes.io/api/"+day+"/"+month))
                .header("accept", "application/json")
                .build();
    /* 1.Request quotes by keyword https://zenquotes.io/api/quotes/[YOUR_API_KEY]&keyword=happiness
    do I need to generate separate JSON array of available keywords via API call by using this link: https://zenquotes.io/api/keywords/[YOUR_API_KEY]?
    is it the same process as with requesting the random quote?
    2. https://zenquotes.io/api/authors/[key] to return array of authors
    3. bot throwing motivational quotes by specific time of the day? or day of the week, should we implement calendar class?
    4. adding event of the day https://today.zenquotes.io/api/ = On This Day API URL. Required.
[month] = Numerical representation of month 1-12.
[day] = Numerical representation of day 1-31.
    5. maybe we could create something like a landing page with inspirational quote and event of the day? or just print out this info
    6. Functionality of the project: Maybe start from the Scanner, user inputting their name of their favorite inspirational persona (getting checked if this is in the list of authors)
    if not requesting the user to put another name, till it will be in our list.
     and date of birth, and see the on the display random quote from this author and event in the history on the same day.

        */
        try {
            // to avoid mistakes if the internet connection is unstable or API is not working
            HttpResponse<String> response = client.send(programmingEventRequest, HttpResponse.BodyHandlers.ofString());

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
            //catching problem on the line 52, something wrong with the typeReference
            e.printStackTrace();
            System.out.println("Error");

        }
    }
}
