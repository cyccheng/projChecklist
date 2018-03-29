package com.mobapp.checklistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobapp.checklistapp.util.MobappApplicationState;

/**
 * Created by sherynn on 27/03/2018.
 */

public class MobappActivity  extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MobappApplicationState.getInstance().setCurrentActivity(this);
        MobappApplicationState.getInstance().setCurrentActiveContext(this);
    }

    public void onStart() {
        super.onStart();
    }
}
