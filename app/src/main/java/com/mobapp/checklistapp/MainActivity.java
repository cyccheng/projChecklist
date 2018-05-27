package com.mobapp.checklistapp;

import android.os.Handler;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobapp.checklistapp.util.MobappUtil;
import com.mobapp.checklistapp.util.MobappViewControlManager;
import com.mobapp.checklistapp.vo.LoginVO;

public class MainActivity extends MobappActivity {

    DatabaseReference ref;
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ref = FirebaseDatabase.getInstance().getReference("UserTable");

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MobappViewControlManager.getInstance().routeAfterSplashScreen();
            }
        }, 1000);
    }

    @Override
    public void onStart() {
        super.onStart();
/*
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //String zzz = dataSnapshot.getKey();
                //String zzz = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
                //LoginVO userName = new LoginVO();
                String tex = dataSnapshot.getValue(String.class);
                //userName.setUserID(tex.getUser(user));
                System.out.println("From main activity");
                //System.out.println(zzz.user);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/


    }
}
