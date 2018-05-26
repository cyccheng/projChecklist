package com.mobapp.checklistapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by sherynn on 30/03/2018.
 */

public class HomeUserView extends FrameLayout {

    private Context parentContext;

    public HomeUserView(Context context) {
        super(context);
        parentContext = (Context) context;
        initData();
    }

    public HomeUserView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parentContext = (Context) context;

        initData();
    }

    public HomeUserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        parentContext = (Context) context;
        initData();
    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void initData() {
        //Load payment entry xml
        LayoutInflater layoutInflater = (LayoutInflater) parentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.home_user_view, this);

    }
}