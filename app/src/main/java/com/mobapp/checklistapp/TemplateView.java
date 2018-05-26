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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobapp.checklistapp.util.MobappApplicationState;
import com.mobapp.checklistapp.util.MobappConstant;

import java.util.ArrayList;

/**
 * Created by sherynn on 30/03/2018.
 */

public class TemplateView extends FrameLayout {


    private Context parentContext;
    private ListView listTemplate;
    String showTemplate_data;
    private DatabaseReference ref;


    public void test() {


    }

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

        ref = FirebaseDatabase.getInstance().getReference("TemplateList");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final ArrayList<String> templateList = new ArrayList<String>();
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    templateList.add(ds.getValue(String.class));
                }

                String[] arrTemplate = new String[templateList.size()];
                arrTemplate = templateList.toArray(arrTemplate);

                listTemplate = (ListView) findViewById(R.id.listTemplate);

                ArrayAdapter adapter = new ArrayAdapter<String>(MobappApplicationState.getInstance().getCurrentActiveContext(), R.layout.activity_listitemrow, arrTemplate);
                listTemplate.setAdapter(adapter);

                listTemplate.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String data=(String)parent.getItemAtPosition(position);
                        Intent intent = new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), TemplateActivity.class);
                        //intent.putExtra(MobappConstant.TEMPLATE_VIEW_INTENT_TEMPLATE_ID, data);
                        intent.putExtra("templateID_passed", data);

                        MobappApplicationState.getInstance().getCurrentActivity().startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}