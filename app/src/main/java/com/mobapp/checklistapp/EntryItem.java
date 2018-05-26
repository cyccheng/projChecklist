package com.mobapp.checklistapp;

/**
 * Created by Cyc on 5/25/2018.
 */

public class EntryItem implements Item {
    public final String title;

    public EntryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean isSection() {
        return false;
    }
}
