package org.example;

public class Quote {
    public String q;
    public String a;
    public String h;

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