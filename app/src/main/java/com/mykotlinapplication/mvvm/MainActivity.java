package com.mykotlinapplication.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mykotlinapplication.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getData().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                Toast.makeText(MainActivity.this, "Welcome, " + userModel.getEmail(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
