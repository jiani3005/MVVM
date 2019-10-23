package com.mykotlinapplication.exercise.repositories;

import android.util.Log;

import com.mykotlinapplication.exercise.models.Place;
import com.mykotlinapplication.exercise.networks.ApiClient;
import com.mykotlinapplication.exercise.networks.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceRepository {

    private static PlaceRepository instance;
    private ArrayList<Place> dataSet = new ArrayList<>();
    private static ApiInterface apiInterface;

    public PlaceRepository() {
        String BASE_URL = "https://jsonplaceholder.typicode.com";
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static PlaceRepository getInstance() {

        if (instance == null) {
            instance = new PlaceRepository();
        }

        return instance;
    }

    // Pretend to get data from online source
    public MutableLiveData<ArrayList<Place>> getPlaces() {

//        setPlaces();

        MutableLiveData<ArrayList<Place>> data = new MutableLiveData<>();

        apiInterface.loadPlaces().enqueue(new retrofit2.Callback<ArrayList<Place>>() {
            @Override
            public void onResponse(Call<ArrayList<Place>> call, Response<ArrayList<Place>> response) {
                for (Place p: response.body()) {
                    Log.i("Repo", "title = " + p.getTitle());
                }

                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Place>> call, Throwable t) {
                Log.e("PlaceRepository", t.toString());
            }
        });

//        data.setValue(dataSet);

        return data;
    }

    private void setPlaces() {

        dataSet.add(new Place("Paris", "https://travel.usnews.com/dims4/USNEWS/d6b0a40/2147483647/resize/445x280%5E%3E/crop/445x280/quality/85/?url=travel.usnews.com/static-travel/images/destinations/86/gettyimages-532590277_445x280.jpg"));
        dataSet.add(new Place("New Zealand", "https://travel.usnews.com/dims4/USNEWS/3303459/2147483647/resize/445x280%5E%3E/crop/445x280/quality/85/?url=travel.usnews.com/static-travel/images/destinations/331/edited_south_island_nz_getty_irma_ferreira_445x280.jpg"));
        dataSet.add(new Place("Rome", "https://travel.usnews.com/dims4/USNEWS/f9e8e39/2147483647/resize/445x280%5E%3E/crop/445x280/quality/85/?url=travel.usnews.com/static-travel/images/destinations/108/main_image_cropped_rome_445x280.jpg"));
        dataSet.add(new Place("Tahiti", "https://travel.usnews.com/dims4/USNEWS/cff09fd/2147483647/resize/445x280%5E%3E/crop/445x280/quality/85/?url=travel.usnews.com/static-travel/images/destinations/288/tahiti_main_getty_samantha_t_photography_edited_445x280.jpg"));
        dataSet.add(new Place("London", "https://travel.usnews.com/dims4/USNEWS/53e8142/2147483647/resize/445x280%5E%3E/crop/445x280/quality/85/?url=travel.usnews.com/static-travel/images/destinations/82/482151882_445x280.jpg"));

    }
}
