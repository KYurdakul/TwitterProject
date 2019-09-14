package com.example.kerem.twitterproject.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TwitterData {
    @SerializedName("statuses")
    List<Statuses> statuses;

    public List<Statuses> getStatuses() {
        return statuses;
    }
}
