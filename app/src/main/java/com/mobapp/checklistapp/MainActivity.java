package com.mobapp.checklistapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //if logged in, show home screen
//                showHomeScreen();
                //else
                showLoginScreen();
            }
        }, 2000);

    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void showLoginScreen() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void showHomeScreen() {
        //check if user status is user or admin, route to different screen
//        startActivity(new Intent(this, HomeAdminActivity.class));
        startActivity(new Intent(this, HomeUserActivity.class));
    }
}
