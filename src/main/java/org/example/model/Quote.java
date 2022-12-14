package org.example.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Quote {
    @JsonIgnoreProperties(value = { "h"})
    public String q;
    public String a;
    public String h;
    public Integer c;

    public Quote() {
    }

    public String getQuote() {
        return q;
    }

    public void setQuote(String q) {
        this.q = q;
    }

    public String getAuthor() {
        return a;
    }

    public void setAuthor(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "q='" + q + '\'' +
                ", a='" + a + '\'' +

                '}';
    }
}