package com.myAnandbank.model;

import java.util.UUID;

public class Transactions {
    private String id;
    private Integer amount;
    private String timeStamp;
    private String reference;

    public String getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Transactions(Integer amount, String timeStamp){
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.reference = "eating out at mcdonalds";

    }


}
