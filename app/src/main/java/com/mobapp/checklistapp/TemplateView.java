package com.mobapp.checklistapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

/**
 * Created by sherynn on 30/03/2018.
 */

public class TemplateView extends FrameLayout {


    private Context parentContext;
    private ListView listTemplate;
    String showTemplate_data;
    private FirebaseDatabase mFdb;
    private DatabaseReference ref;


    public void onCreate(Bundle savedInstanceState) {

        ref = FirebaseDatabase.getInstance().getReference("userID");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //String zzz = dataSnapshot.getKey();
                //String zzz = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
                //LoginVO userName = new LoginVO();
                showTemplate_data = dataSnapshot.getValue(String.class);
                //userName.setUserID(tex.getUser(user));
                //System.out.println(tex);
                //System.out.println(zzz.user);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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

    DatabaseReference mDatabase;


    private void initData() {
        //Load payment entry xml

        LayoutInflater layoutInflater = (LayoutInflater) parentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.template_view, this);

        listTemplate = (ListView) findViewById(R.id.listTemplate);
        showTemplate_data = "Template 33";
        final String[] arrTemplate = {"Template 1","Template 2", showTemplate_data};
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