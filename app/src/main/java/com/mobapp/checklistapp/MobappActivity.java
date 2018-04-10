package com.mobapp.checklistapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mobapp.checklistapp.util.MobappApplicationState;

/**
 * Created by sherynn on 27/03/2018.
 */

public class MobappActivity  extends AppCompatActivity {

    private ViewGroup customContentView;
    private View viewTopBar;
//    private BottomNavigationView viewBottomBar;
    private TextView txtNavTitle;
    private ImageButton btnBack;
    private ImageButton btnAdd;

    private View currentAttachedView;
    private View viewToBeRemove;

//    private static final String SELECTED_ITEM = "selected_item";
//    private int intSelectedItem;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MobappApplicationState.getInstance().setCurrentActivity(this);
        MobappApplicationState.getInstance().setCurrentActiveContext(this);

        setContentView(R.layout.custom_ui_base);
        initUI();

//        MenuItem selectedItem;
//        if (savedInstanceState != null) {
//            intSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
//            selectedItem = viewBottomBar.getMenu().findItem(intSelectedItem);
//        } else {
//            selectedItem = viewBottomBar.getMenu().getItem(0);
//        }
//        selectFragment(selectedItem);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putInt(SELECTED_ITEM, intSelectedItem);
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    public void onBackPressed() {
//        MenuItem itemHome = viewBottomBar.getMenu().getItem(0);
//        if (intSelectedItem != itemHome.getItemId()) {
//            // select home item
//            selectFragment(itemHome);
//        } else {
//            super.onBackPressed();
//        }
//    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void initUI() {
        customContentView = (ViewGroup) findViewById(R.id.viewContent);
        viewTopBar = (View) findViewById(R.id.viewTopBar);
//        viewBottomBar = (BottomNavigationView) findViewById(R.id.viewBottomBar);
        txtNavTitle = (TextView) findViewById(R.id.txtNavTitle);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnAdd = (ImageButton) findViewById(R.id.btnAdd);

        setTopBarViewHidden(true);
//        setBottomBarViewHidden(true);

//        viewBottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                selectFragment(item);
//                return true;
//            }
//        });
    }

//    private void selectFragment(MenuItem item) {
//        Fragment frag = null;
//        // init corresponding fragment
//        switch (item.getItemId()) {
//            case R.id.bottomBarBtnHome:
//                MobappViewControlManager.getInstance().routeToHomeWithViewType(0);
//                break;
//            case R.id.bottomBarBtnTemplate:
//                MobappViewControlManager.getInstance().routeToHomeWithViewType(1);
//                break;
//            case R.id.bottomBarBtnSettings:
//                MobappViewControlManager.getInstance().routeToHomeWithViewType(2);
//                break;
//        }
//
//        // update selected item
//        intSelectedItem = item.getItemId();
//
//        // uncheck the other items.
//        for (int i = 0; i< viewBottomBar.getMenu().size(); i++) {
//            MenuItem menuItem = viewBottomBar.getMenu().getItem(i);
//            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
//        }
//
//        updateToolbarText(item.getTitle());
//
//        if (frag != null) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.add(R.id.container, frag, frag.getTag());
//            ft.commit();
//        }
//    }
//
//    private void updateToolbarText(CharSequence text) {
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle(text);
//        }
//    }

    // ============================================================================================
    // Public Methods
    // ============================================================================================

    public void setContentViewWithAnimation(int id, Boolean animated)
    {
        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewAdded = inflater.inflate(id, null);

        setContentViewWithAnimation(viewAdded, animated);
    }

    //replace previous attached view.
    public void setContentViewWithAnimation(View view, Boolean animated)
    {
        View viewAdded = view;

        customContentView.addView(viewAdded);

        if (currentAttachedView != null)
        {
            viewToBeRemove = currentAttachedView;
            currentAttachedView = viewAdded;

            customContentView.removeView(viewToBeRemove);
        }
        else
        {
            currentAttachedView = viewAdded;
        }
    }

    // add a view on top of contentview without removing previous attached view.
    public void addContentViewWithAnimation(View view, Boolean animated)
    {
        View viewAdded = view;

        customContentView.addView(viewAdded);
        currentAttachedView = viewAdded;
    }

    // remove the childview on top of contentView
    public void removeContentViewWithAnimation(Boolean animated)
    {
        int subviewCount = customContentView.getChildCount();

        if (subviewCount > 0)
        {
            if (currentAttachedView != null)
            {
                if (subviewCount - 1 > 0)
                {
                    //set currentAttachedView to last 2 childview
                    currentAttachedView = customContentView.getChildAt(subviewCount - 2);
                }
                else
                {
                    currentAttachedView = null;
                }
            }

            viewToBeRemove = customContentView.getChildAt(subviewCount - 1);
            customContentView.removeViewAt(customContentView.getChildCount() - 1);
        }
    }

    public void setNavTitle(CharSequence text) {
        txtNavTitle.setText(text);
        setNavTitleHidden(false);
    }

    public void setNavTitle(int id) {
        txtNavTitle.setText(getResources().getString(id));
        setNavTitleHidden(false);
    }

    public void setNavTitleHidden(boolean hidden) {
        txtNavTitle.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }

    public void setTopBarViewHidden(boolean hidden) {
        viewTopBar.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }

//    public void setBottomBarViewHidden(boolean hidden) {
//        viewBottomBar.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
//    }

    public void setNavBackButtonHidden(boolean hidden) {
        btnBack.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }

    public void setNavAddButtonHidden(boolean hidden) {
        btnAdd.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }

    // ============================================================================================
    // Button Action
    // ============================================================================================

    public void btnNavBackOnClicked(View view) {
        finish();
    }

    public void btnNavAddOnClicked(View view) {

    }

    public void onStart() {
        super.onStart();
    }
}
