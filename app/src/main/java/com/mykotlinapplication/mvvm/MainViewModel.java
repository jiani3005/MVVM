package com.mykotlinapplication.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData userModelMutableLiveData;

    public MutableLiveData<UserModel> getData() {

        if (userModelMutableLiveData == null) {
            userModelMutableLiveData = new MutableLiveData();
            loadData();
        }

        return userModelMutableLiveData;
    }


    public void loadData() {

        UserModel userModel = new UserModel("zack@gmail.com", "12345");

        userModelMutableLiveData.setValue(userModel);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
