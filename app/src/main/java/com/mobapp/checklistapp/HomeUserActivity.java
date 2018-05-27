package com.mobapp.checklistapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by sherynn on 27/03/2018.
 */

public class HomeUserActivity extends HomeMainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_user);

        //Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        //FontManager.markAsIconContainer(findViewById(R.id.testFont), iconFont);

//        super.setViewContent(R.layout.activity_home_user);
//        super.setNavBtnBackHidden(true);
//        super.setNavTitle(getString(R.string.HOME_NAV_TITLE));
    }
}