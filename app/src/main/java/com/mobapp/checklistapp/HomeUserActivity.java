package com.mobapp.checklistapp;

import android.os.Bundle;

/**
 * Created by sherynn on 27/03/2018.
 */

public class HomeUserActivity extends HomeMainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_user);
//        super.setViewContent(R.layout.activity_home_user);
//        super.setNavBtnBackHidden(true);
//        super.setNavTitle(getString(R.string.HOME_NAV_TITLE));
    }
}