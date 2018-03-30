package com.mobapp.checklistapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Created by sherynn on 30/03/2018.
 */

public class TemplateView extends FrameLayout {

    private Context parentContext;

    public TemplateView(Context context) {
        super(context);
        parentContext = (Context) context;
        initData();
    }

    public TemplateView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parentContext = (Context) context;

        initData();
    }

    public TemplateView(Context context, AttributeSet attrs) {
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
        layoutInflater.inflate(R.layout.template_view, this);
    }
}