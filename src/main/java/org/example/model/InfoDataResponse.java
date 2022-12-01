package org.example.model;

public class InfoDataResponse {
   private String info;
    private String date;
    private Integer updated;
    private Data data;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "InfoDataResponse{" +
                "info='" + info + '\'' +
                ", date='" + date + '\'' +
                ", updated=" + updated +
                ", data=" + data +
                '}';
    }
}
