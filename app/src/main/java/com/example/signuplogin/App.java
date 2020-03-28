package com.example.signuplogin;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import static com.parse.Parse.initialize;

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Lg2i9LyJiag5l0BLjwuKMrLGuKR33CO8BQBCGm42")
                // if defined
                .clientKey("BrcO53XQcmWKGInWgc9LRAdMLFh0NjmVG6moeUMW")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}

