package com.example.retrofitakmaralabdylmanapkyzyakmaralain_2_20.data;

import com.google.gson.annotations.SerializedName;

public class ModelDo {
    @SerializedName("key")
    private String key;

    @SerializedName("activity")
    private String activity;

    @SerializedName("price")
    private double price;

    @SerializedName("type")
    private String type;

    @SerializedName("link")
    private String link;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}