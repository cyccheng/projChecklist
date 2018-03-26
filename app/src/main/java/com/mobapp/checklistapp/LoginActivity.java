package com.mobapp.checklistapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sherynn on 26/03/2018.
 */

public class LoginActivity extends MobappActivity {

    private EditText txtUserID;
    private EditText txtPassword;
    private Button btnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void initUI() {
        txtUserID = (EditText) findViewById(R.id.txtLoginID);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    private Boolean validateTextField() {
        if (TextUtils.isEmpty(txtUserID.getText().toString()) || TextUtils.isEmpty(txtUserID.getText().toString())) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Incomplete");
            alertDialog.setMessage("All fields are required.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

            return false;
        }

        // any validation for userID and password? length?

        return true;
    }

    // ============================================================================================
    // Button Action
    // ============================================================================================

    public void btnLoginOnClicked(View view) {
        if (validateTextField()) {
            requestLogin();
        }
    }

    // ============================================================================================
    // Service Request
    // ============================================================================================

    private void requestLogin() {

    }

}