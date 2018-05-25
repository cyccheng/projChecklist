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
    Long templateID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentViewWithAnimation(R.layout.activity_template, false);
        super.setTopBarViewHidden(false);
        super.setNavAddButtonHidden(true);
        super.setNavTitle(getString(R.string.TEMPLATE_NAV_TITLE));
        super.setNavNextButtonHidden(false);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            templateID = bundle.getLong(MobappConstant.TEMPLATE_VIEW_INTENT_TEMPLATE_ID);
        }

        ref = FirebaseDatabase.getInstance().getReference("Question");


        //initUI();
    }

    @Override
    public void onStart() {
        super.onStart();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //String zzz = dataSnapshot.getKey();
                //String zzz = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
                //LoginVO userName = new LoginVO();

                initUI(dataSnapshot);
                //userName.setUserID(tex.getUser(user));
                //System.out.println(tex);
                //System.out.println(zzz.user);

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

        final ArrayList<String> mylist = new ArrayList<String>();
        for(DataSnapshot ds: dataSnapshot.getChildren()){

            mylist.add(ds.getValue(String.class));
        }

        String[] arrTestQuest = new String[mylist.size()];
        arrTestQuest = mylist.toArray(arrTestQuest);


        //showQuest = dataSnapshot.getValue(String.class);

        final String[] arrQuestion = MobappApplicationState.getInstance().getCurrentActiveContext().getResources().getStringArray(R.array.GH2_1);
//        ArrayAdapter adapter = new ArrayAdapter<String>(MobappApplicationState.getInstance().getCurrentActiveContext(), R.layout.activity_listitemrow_question, arrQuestion);
        QuestionListViewAdapter adapter = new QuestionListViewAdapter(MobappApplicationState.getInstance().getCurrentActivity(), arrTestQuest);
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