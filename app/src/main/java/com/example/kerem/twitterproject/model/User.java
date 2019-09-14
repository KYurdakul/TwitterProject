package com.example.kerem.twitterproject.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    String name;

    @SerializedName("screen_name")
    String screenName;

    @SerializedName("profile_image_url")
    String profileImage;


    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getBackgroundImage() {
        return profileImage;
    }
}
