package com.mykotlinapplication.exercise.networks;

import com.mykotlinapplication.exercise.models.Place;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/photos")
    Call<ArrayList<Place>> loadPlaces();
}
