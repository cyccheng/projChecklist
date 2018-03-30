package com.mobapp.checklistapp.util;

import android.content.Context;
import android.content.Intent;
import android.view.inputmethod.InputMethodManager;

import com.mobapp.checklistapp.HomeAdminActivity;
import com.mobapp.checklistapp.HomeMainActivity;
import com.mobapp.checklistapp.HomeUserActivity;
import com.mobapp.checklistapp.LoginActivity;

import junit.framework.Assert;

/**
 * Created by sherynn on 27/03/2018.
 */

public class MobappViewControlManager
{
    private static MobappViewControlManager instance = null;

    // ============================================================================================
    // Constructors
    // ============================================================================================

    public MobappViewControlManager()
    {
        Assert.assertTrue("Duplication of singleton instance", instance == null);
    }

    public final static MobappViewControlManager getInstance()
    {
        if (instance == null)
        {
            synchronized (MobappViewControlManager.class)
            {
                if (instance == null)
                {
                    instance = new MobappViewControlManager();
                }
            }
        }

        return instance;
    }

    // ============================================================================================
    // Public Methods
    // ============================================================================================

    public final static void resetInstance()
    {
        instance = null;
    }

    public void routeAfterSplashScreen() {
//        if (MobappUserDataHandler.getInstance().isLoggedIn()) {
            MobappViewControlManager.getInstance().showHomeScreen();
//        }
//        else {
//            MobappViewControlManager.getInstance().showLoginScreen();
//        }
    }

    public void routeToHomeWithViewType(int viewType) {
        Intent intent = new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), HomeMainActivity.class);
        intent.putExtra(MobappConstant.HOME_INTENT_VIEW_TYPE, viewType);

        MobappApplicationState.getInstance().getCurrentActivity().startActivity(intent);
    }

    public void routeAfterLogout() {
        MobappViewControlManager.getInstance().showLoginScreen();
    }

    public void dismissKeyboard() {
        InputMethodManager imm = (InputMethodManager)MobappApplicationState.getInstance().getCurrentActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(MobappApplicationState.getInstance().getCurrentActivity().getCurrentFocus().getWindowToken(), 0);
    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private void showLoginScreen() {
        MobappApplicationState.getInstance().getCurrentActivity().startActivity(new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), LoginActivity.class));
    }

    private void showHomeScreen() {
        MobappApplicationState.getInstance().getCurrentActivity().startActivity(new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), HomeMainActivity.class));

//        if (MobappUserDataHandler.getInstance().getUserIdentity() == MobappConstant.MOBAPP_USER_IDENTITY_ADMIN) {
//            MobappApplicationState.getInstance().getCurrentActivity().startActivity(new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), HomeAdminActivity.class));
//        }
////        else {
//        MobappApplicationState.getInstance().getCurrentActivity().startActivity(new Intent(MobappApplicationState.getInstance().getCurrentActiveContext(), HomeUserActivity.class));
////        }
    }
}