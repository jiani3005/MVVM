package com.mykotlinapplication.exercise.models;

import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("title") private String title;
    @SerializedName("thumbnailUrl") private String image;

    public Place () {

    }

    public Place(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
