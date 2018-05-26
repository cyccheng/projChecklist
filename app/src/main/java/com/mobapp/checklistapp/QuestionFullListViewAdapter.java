package com.mobapp.checklistapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sherynn on 10/04/2018.
 */

public class QuestionFullListViewAdapter extends BaseAdapter {

    Activity context;
    private ArrayList<Item> item;
    private ArrayList<Item> originalItem;

    public QuestionFullListViewAdapter() {
        super();
    }

    public QuestionFullListViewAdapter(Activity context, ArrayList<Item> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (item.get(position).isSection()) {
            // if section header
            convertView = inflater.inflate(R.layout.activity_listitemrow_section, parent, false);
            TextView tvSectionTitle = (TextView) convertView.findViewById(R.id.tvSectionTitle);
            tvSectionTitle.setText(((SectionItem) item.get(position)).getTitle());
        }
        else
        {
            // if item
            convertView = inflater.inflate(R.layout.activity_listitemrow_question, parent, false);
            TextView tvItemTitle = (TextView) convertView.findViewById(R.id.lblTitle);
            tvItemTitle.setText(((EntryItem) item.get(position)).getTitle());
        }

        return convertView;
    }
}