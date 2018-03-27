package com.mobapp.checklistapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mobapp.checklistapp.util.MobappViewControlManager;
import com.mobapp.checklistapp.vo.LoginVO;

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

    private Boolean inputValidation() {
        if (TextUtils.isEmpty(txtUserID.getText().toString()) || TextUtils.isEmpty(txtUserID.getText().toString())) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(getString(R.string.ALERT_INCOMPLETE_TITLE));
            alertDialog.setMessage(getString(R.string.ALERT_INCOMPLETE_MSG));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ALERT_BTN_OK),
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

    private void clearText() {
        txtUserID.setText("");
        txtPassword.setText("");
    }

    // ============================================================================================
    // Button Action
    // ============================================================================================

    public void btnLoginOnClicked(View view) {
        if (inputValidation()) {
            requestLogin();
        }
    }

    // ============================================================================================
    // Service Request
    // ============================================================================================

    private void requestLogin() {
        MobappViewControlManager.getInstance().dismissKeyboard();
        ProgressDialog.show(this, getString(R.string.PROGRESS_DIALOG_TITLE), getString(R.string.PROGRESS_DIALOG_MSG));

        LoginVO loginVO = new LoginVO();
        loginVO.setUserID(txtUserID.getText().toString());
        loginVO.setPassword(txtPassword.getText().toString());

        //send to server
    }
}