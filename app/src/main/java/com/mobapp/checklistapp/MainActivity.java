package com.mobapp.checklistapp;

import android.os.Handler;
import android.os.Bundle;

import com.mobapp.checklistapp.util.MobappViewControlManager;

public class MainActivity extends MobappActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MobappViewControlManager.getInstance().routeAfterSplashScreen();
            }
        }, 2000);

    }
}
