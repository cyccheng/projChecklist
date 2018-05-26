package com.mobapp.checklistapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobapp.checklistapp.util.MobappApplicationState;
import com.mobapp.checklistapp.util.MobappConstant;

import java.util.ArrayList;

/**
 * Created by sherynn on 25/05/2018.
 */

public class CaptureSignatureActivity extends MobappActivity {

    SignaturePad signaturePad;
    Bitmap signatureBitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentViewWithAnimation(R.layout.activity_capture_signature, false);
        super.setTopBarViewHidden(false);
        super.setNavAddButtonHidden(true);
        super.setNavTitle(getString(R.string.CAPTURE_SIGNATURE_NAV_TITLE));
        super.setBtnNextTitle(getString(R.string.BTN_SAVE));

        initUI();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void initUI() {
        signaturePad = (SignaturePad) findViewById(R.id.signaturePad);
    }

    // ============================================================================================
    // Button Action
    // ============================================================================================

    public void btnNavNextOnClicked(View view) {
        if (!signaturePad.isEmpty()) {
            signatureBitmap = signaturePad.getSignatureBitmap();
        }
    }

    public void btnClearOnClicked(View view) {
        signaturePad.clear();
    }
}