package com.example.kerem.twitterproject.model;

import com.google.gson.annotations.SerializedName;

public class Statuses {
    @SerializedName("text")
    private String text;

    @SerializedName("created_at")
    private String date;

    @SerializedName("user")
    User user;

    public User getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
