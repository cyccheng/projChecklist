package com.mobapp.checklistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
 * Created by sherynn on 10/04/2018.
 */

public class TemplateActivity extends MobappActivity {

    private ListView listQuestion;
    String showQuest;
    DatabaseReference ref;
    String templateID;

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
        //initUI();
    }

    @Override
    public void onStart() {
        super.onStart();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                initUI(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void initUI(DataSnapshot dataSnapshot) {
        listQuestion = (ListView) findViewById(R.id.listQuestion);
        int i = 1;

        ArrayList<Item> questList = new ArrayList<Item>();

        for(DataSnapshot ds: dataSnapshot.getChildren()){
            questList.add(new SectionItem(ds.getKey()));
            DataSnapshot question_Inner = dataSnapshot.child(ds.getKey());
            Iterable<DataSnapshot> question_Child = question_Inner.getChildren();
            for (DataSnapshot innerLoopz: question_Child){
                questList.add(new EntryItem(innerLoopz.getValue(String.class)));
            }
        }

        final String[] arrQuestion = MobappApplicationState.getInstance().getCurrentActiveContext().getResources().getStringArray(R.array.GH2_1);
//        ArrayAdapter adapter = new ArrayAdapter<String>(MobappApplicationState.getInstance().getCurrentActiveContext(), R.layout.activity_listitemrow_question, arrQuestion);
        //QuestionListViewAdapter adapter = new QuestionListViewAdapter(MobappApplicationState.getInstance().getCurrentActivity(), questList);

        QuestionFullListViewAdapter adapter = new QuestionFullListViewAdapter(MobappApplicationState.getInstance().getCurrentActivity(), questList);
        listQuestion.setAdapter(adapter);
        
        View header = (View) getLayoutInflater().inflate(R.layout.view_template_header, null);
        View footer = (View) getLayoutInflater().inflate(R.layout.view_template_footer, null);
        listQuestion.addHeaderView(header);
        listQuestion.addFooterView(footer);
    }


    // ============================================================================================
    // Button Action
    // ============================================================================================

    public void btnNavNextOnClicked(View view) {
        MobappApplicationState.getInstance().getCurrentActivity().startActivity(new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), CaptureSignatureActivity.class));
    }
}