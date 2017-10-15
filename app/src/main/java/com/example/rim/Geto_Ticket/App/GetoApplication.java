package com.example.rim.Geto_Ticket.App;

import android.app.Application;
import android.content.Intent;

import com.example.rim.Geto_Ticket.UI.Activity.SplashScreenActivity;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by rim
 */

public class GetoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        Intent intent = new Intent(this, SplashScreenActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
