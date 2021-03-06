package com.mobapp.checklistapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobapp.checklistapp.util.MobappApplicationState;
import com.mobapp.checklistapp.util.MobappConstant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sherynn on 10/04/2018.
 */

public class TemplateActivity extends MobappActivity {

    private ListView listQuestion;
    String showQuest;
    DatabaseReference ref;
    String templateID;
    private TextView lblStatus;
    private TextView lblCreatedOn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentViewWithAnimation(R.layout.activity_template, false);
        super.setTopBarViewHidden(false);
        super.setNavAddButtonHidden(true);
        super.setNavTitle(getString(R.string.TEMPLATE_NAV_TITLE));
        super.setNavNextButtonHidden(false);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                templateID = bundle.getString("templateID_passed");
                //templateID = bundle.getLong(MobappConstant.TEMPLATE_VIEW_INTENT_TEMPLATE_ID);
            }
        } else {
            templateID = (String)savedInstanceState.getSerializable("templateID_passed");
        }

        ref = FirebaseDatabase.getInstance().getReference(templateID);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                initUI(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //initUI();
    }
/*
    @Override
    public void onStart() {
        super.onStart();





    }
*/
    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void initUI(DataSnapshot dataSnapshot) {


        listQuestion = (ListView) findViewById(R.id.listQuestion);

        ArrayList<Item> questList = new ArrayList<Item>();

        for(DataSnapshot ds: dataSnapshot.getChildren()){
            questList.add(new SectionItem(ds.getKey()));
            DataSnapshot question_Inner = dataSnapshot.child(ds.getKey());
            Iterable<DataSnapshot> question_Child = question_Inner.getChildren();
            for (DataSnapshot innerLoopz: question_Child){
                questList.add(new EntryItem(innerLoopz.getValue(String.class)));
            }
        }

        //final String[] arrQuestion = MobappApplicationState.getInstance().getCurrentActiveContext().getResources().getStringArray(R.array.GH2_1);
//        ArrayAdapter adapter = new ArrayAdapter<String>(MobappApplicationState.getInstance().getCurrentActiveContext(), R.layout.activity_listitemrow_question, arrQuestion);
        //QuestionListViewAdapter adapter = new QuestionListViewAdapter(MobappApplicationState.getInstance().getCurrentActivity(), questList);

        QuestionFullListViewAdapter adapter = new QuestionFullListViewAdapter(MobappApplicationState.getInstance().getCurrentActivity(), questList);
        listQuestion.setAdapter(adapter);

        View header = (View) getLayoutInflater().inflate(R.layout.view_template_header, null);
        View footer = (View) getLayoutInflater().inflate(R.layout.view_template_footer, null);

        Date dt = Calendar.getInstance().getTime();
        //System.out.println("Current time => " + c);

        SimpleDateFormat dt_format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String current_Date = dt_format.format(dt);

        lblStatus = header.findViewById(R.id.lblStatus);
        lblCreatedOn = header.findViewById(R.id.lblCreatedOn);
        lblStatus.setText("Not Submit");
        lblCreatedOn.setText(current_Date);
        listQuestion.addHeaderView(header);
        listQuestion.addFooterView(footer);
    }


    // ============================================================================================
    // Button Action
    // ============================================================================================

    public void btnNavNextOnClicked(View view) {

        //Integer checkCt = listQuestion.getCount();
        //System.out.print(checkCt);
        //SparseBooleanArray checked = listQuestion.getCheckedItemPositions();
        //for (int i = 0; i < checked.size(); i++) {
            //if (checked.valueAt(i) == true) {
               // String tag = String.valueOf(listQuestion.getItemAtPosition(checked.keyAt(i)));
                //Toast.makeText(getApplicationContext(), "" + tag, Toast.LENGTH_LONG).show();
                //Toast.makeText(MobappActivity.this, "Onclicklistener function called.", Toast.LENGTH_LONG).show();
                //Log.i("xxxx", i + " " + tag);
            //}
       // }

        MobappApplicationState.getInstance().getCurrentActivity().startActivity(new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), CaptureSignatureActivity.class));
    }
}