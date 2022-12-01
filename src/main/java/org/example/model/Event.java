package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;

public class Event {
    @JsonIgnoreProperties(value = { "html","links"})

    private String text;
    public String html;
    public HashMap<Integer, HashMap<Integer,String> > links;
    public String getText () {
        return text;
    }

    public void setText (String text) {

        this.text = text;
    }
    @Override
    public String toString() {
        return "Event{" +
                "text='" + text + '\'' +
                ", html='" + html + '\'' +
                //", links=" + links +
                '}';
    }
}
