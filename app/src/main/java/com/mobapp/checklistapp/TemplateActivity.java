package com.mobapp.checklistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.mobapp.checklistapp.util.MobappApplicationState;

/**
 * Created by sherynn on 10/04/2018.
 */

public class TemplateActivity extends MobappActivity {

    private ListView listQuestion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentViewWithAnimation(R.layout.activity_template, false);
        super.setTopBarViewHidden(false);
        super.setNavAddButtonHidden(true);
        super.setNavTitle(getString(R.string.TEMPLATE_NAV_TITLE));

        initUI();
    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void initUI() {
        listQuestion = (ListView) findViewById(R.id.listQuestion);

        final String[] arrQuestion = MobappApplicationState.getInstance().getCurrentActiveContext().getResources().getStringArray(R.array.GH2_1);
//        ArrayAdapter adapter = new ArrayAdapter<String>(MobappApplicationState.getInstance().getCurrentActiveContext(), R.layout.activity_listitemrow_question, arrQuestion);
        QuestionListViewAdapter adapter = new QuestionListViewAdapter(MobappApplicationState.getInstance().getCurrentActivity(), arrQuestion);
        listQuestion.setAdapter(adapter);

        View header = (View) getLayoutInflater().inflate(R.layout.view_template_header, null);
        View footer = (View) getLayoutInflater().inflate(R.layout.view_template_footer, null);
        listQuestion.addHeaderView(header);
        listQuestion.addFooterView(footer);
    }
}