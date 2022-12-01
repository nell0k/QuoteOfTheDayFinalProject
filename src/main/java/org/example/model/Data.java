package org.example.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = { "Births", "Deaths" })

public class Data {
   @JsonProperty ("Events")
   //if API naming is really crazy try to tell the program your own variable names, json will address the actual one in the API while running

    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Data{" +
                "Events=" + events +
                '}';
    }
}
