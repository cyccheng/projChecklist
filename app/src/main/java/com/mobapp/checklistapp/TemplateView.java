package com.mobapp.checklistapp;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.mobapp.checklistapp.util.MobappApplicationState;

/**
 * Created by sherynn on 30/03/2018.
 */

public class TemplateView extends FrameLayout {

    private Context parentContext;
    private ListView listTemplate;

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

        listTemplate = (ListView) findViewById(R.id.listTemplate);

        final String[] arrTemplate = {"Template 1","Template 2","Template 3"};
        ArrayAdapter adapter = new ArrayAdapter<String>(MobappApplicationState.getInstance().getCurrentActiveContext(), R.layout.activity_listitemrow, arrTemplate);
        listTemplate.setAdapter(adapter);

        listTemplate.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MobappApplicationState.getInstance().getCurrentActivity().startActivity(new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), TemplateActivity.class));
            }
        });
    }
}