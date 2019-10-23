package com.mykotlinapplication.exercise.viewmodels;

import android.os.AsyncTask;
import android.util.Log;

import com.mykotlinapplication.exercise.models.Place;
import com.mykotlinapplication.exercise.repositories.PlaceRepository;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Place>> places;
    private PlaceRepository repo;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public void init() {
        if (places != null) {
            return;
        }

        repo = PlaceRepository.getInstance();
        places = repo.getPlaces();

        Log.d("ViewModel", "places = " + places.toString());

//        for (Place p: places.getValue()) {
//            Log.i("ViewModel", "title = " + p.getTitle());
//        }
    }

    public void addNewValue(Place place) {
        isUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayList<Place> currentPlaces = places.getValue();
                currentPlaces.add(place);
                places.postValue(currentPlaces);
                isUpdating.postValue(false);
            }
        }.execute();
    }

    public LiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }

    public LiveData<ArrayList<Place>> getPlaces() {
//        repo.getPlaces();
        return places;
    }
}
