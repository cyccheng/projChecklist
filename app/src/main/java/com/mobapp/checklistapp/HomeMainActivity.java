package com.mobapp.checklistapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by sherynn on 30/03/2018.
 */

public class HomeMainActivity extends MobappActivity {

    public enum HomeViewType
    {
        ViewHomeUser,
        ViewHomeAdmin,
        ViewTemplate,
        ViewSettings
    }

    private HomeViewType currentViewType;
    private ViewGroup homeViewContent;
    private BottomNavigationView viewBottomBar;

    private static final String SELECTED_ITEM = "selected_item";
    private int intSelectedItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentViewWithAnimation(R.layout.activity_home_main, false);
        super.setTopBarViewHidden(false);
        super.setNavNextButtonHidden(true);

        initUI();
        setBottomBarViewHidden(false);

//        if (MobappUserDataHandler.getInstance().getUserIdentity() == MobappConstant.MOBAPP_USER_IDENTITY_ADMIN) {
//            routeToScreen(HomeViewType.ViewHomeAdmin, true);
//        }
//        else {
            routeToScreen(HomeViewType.ViewHomeUser, true);
//        }

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            intSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = viewBottomBar.getMenu().findItem(intSelectedItem);
        } else {
            selectedItem = viewBottomBar.getMenu().getItem(0);
        }
        selectFragment(selectedItem);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, intSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem itemHome = viewBottomBar.getMenu().getItem(0);
        if (intSelectedItem != itemHome.getItemId()) {
            // select home item
            selectFragment(itemHome);
        } else {
            super.onBackPressed();
        }
    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void initUI() {
        homeViewContent = (ViewGroup) findViewById(R.id.homeViewContent);
        viewBottomBar = (BottomNavigationView) findViewById(R.id.viewBottomBar);

        viewBottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.bottomBarBtnHome:
                routeToScreen(HomeViewType.ViewHomeUser, true);
                super.setNavAddButtonHidden(false);
                break;
            case R.id.bottomBarBtnTemplate:
                routeToScreen(HomeViewType.ViewTemplate, true);
                super.setNavAddButtonHidden(true);
                break;
            case R.id.bottomBarBtnSettings:
                routeToScreen(HomeViewType.ViewSettings, true);
                super.setNavAddButtonHidden(true);
                break;
        }

        // update selected item
        intSelectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i< viewBottomBar.getMenu().size(); i++) {
            MenuItem menuItem = viewBottomBar.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }

        super.setNavTitle(item.getTitle());

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, frag, frag.getTag());
            ft.commit();
        }
    }

    private void routeToScreen(HomeViewType viewType, boolean animated) {
        currentViewType = viewType;

        switch (viewType) {
            case ViewHomeUser: {
                super.setNavBackButtonHidden(true);

                HomeUserView homeUserView = new HomeUserView(this);
                addViewToHomeViewContent(homeUserView);
                break;
            }

            case ViewTemplate: {
                super.setNavBackButtonHidden(true);

                TemplateView templateView = new TemplateView(this);
                addViewToHomeViewContent(templateView);
                break;
            }

            case ViewSettings: {
                super.setNavBackButtonHidden(true);

                SettingsView settingsView = new SettingsView(this);
                addViewToHomeViewContent(settingsView);
                break;
            }

            default:
                break;
        }
    }

    private void addViewToHomeViewContent(View view) {
        if (homeViewContent.getChildCount() > 0) {
            homeViewContent.removeAllViews();
        }

        homeViewContent.addView(view);
    }

    public void setBottomBarViewHidden(boolean hidden) {
        viewBottomBar.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }
}