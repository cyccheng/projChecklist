package com.mobapp.checklistapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import junit.framework.Assert;

/**
 * Created by sherynn on 27/03/2018.
 */

public class MobappUserDataHandler
{
    private static MobappUserDataHandler instance = null;
    private static SharedPreferences sharedPreferences = null;
    private static SharedPreferences.Editor spEditor = null;

    // ============================================================================================
    // Constructors
    // ============================================================================================

    public MobappUserDataHandler()
    {
        Assert.assertTrue("Duplication of singleton instance", instance == null);
    }

    public final static MobappUserDataHandler getInstance()
    {
        if (instance == null)
        {
            synchronized (MobappUserDataHandler.class)
            {
                if (instance == null)
                {
                    instance = new MobappUserDataHandler();
                }
            }
        }

        return instance;
    }

    // ============================================================================================
    // Getters & Setters - Shared Preferences User
    // ============================================================================================

    public String getUserID() throws Error
    {
        return getString(MobappConstant.MOBAPP_SHARED_PREFERENCES_KEY_USER_ID);
    }

    public void setUserID(String userID) throws Error
    {
        setString(MobappConstant.MOBAPP_SHARED_PREFERENCES_KEY_USER_ID, userID);
    }

    public String getUserIdentity() throws Error
    {
        return getString(MobappConstant.MOBAPP_SHARED_PREFERENCES_KEY_USER_IDENTITY);
    }

    public void setUserIdentity(String userIdentity) throws Error
    {
        setString(MobappConstant.MOBAPP_SHARED_PREFERENCES_KEY_USER_IDENTITY, userIdentity);
    }

    public Boolean isLoggedIn() throws Error
    {
        return getBoolean(MobappConstant.MOBAPP_SHARED_PREFERENCES_KEY_USER_LOGIN_STATUS);
    }

    public void setIsLoggedIn(Boolean isLoggedIn) throws Error
    {
        setBoolean(MobappConstant.MOBAPP_SHARED_PREFERENCES_KEY_USER_LOGIN_STATUS, isLoggedIn);
    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

    private final static String getString(String key)
    {
        if (key != null)
        {
            sharedPreferences = MobappApplicationState.getInstance().getCurrentActiveContext().getSharedPreferences(MobappConstant.MOBAPP_SHARED_PREFERENCES_USER, Context.MODE_PRIVATE);
            String value = sharedPreferences.getString(key, null);

            return value;
        }

        return null;
    }

    private final static void setString(String key, String value)
    {
        if (key != null)
        {
            sharedPreferences = MobappApplicationState.getInstance().getCurrentActiveContext().getSharedPreferences(MobappConstant.MOBAPP_SHARED_PREFERENCES_USER, Context.MODE_PRIVATE);
            spEditor = sharedPreferences.edit();
            spEditor.putString(key, value);
            spEditor.commit();
        }
    }

    private final static int getInt(String key)
    {
        if (key != null)
        {
            sharedPreferences = MobappApplicationState.getInstance().getCurrentActiveContext().getSharedPreferences(MobappConstant.MOBAPP_SHARED_PREFERENCES_USER, Context.MODE_PRIVATE);
            int value = sharedPreferences.getInt(key, 0);

            return value;
        }

        return 0;
    }

    private final static void setInt(String key, int value)
    {
        if (key != null)
        {
            sharedPreferences = MobappApplicationState.getInstance().getCurrentActiveContext().getSharedPreferences(MobappConstant.MOBAPP_SHARED_PREFERENCES_USER, Context.MODE_PRIVATE);
            spEditor = sharedPreferences.edit();
            spEditor.putInt(key, value);
            spEditor.commit();
        }
    }

    private final static Boolean getBoolean(String key)
    {
        if (key != null)
        {
            sharedPreferences = MobappApplicationState.getInstance().getCurrentActiveContext().getSharedPreferences(MobappConstant.MOBAPP_SHARED_PREFERENCES_USER, Context.MODE_PRIVATE);
            Boolean value = sharedPreferences.getBoolean(key, false);

            return value;
        }

        return false;
    }

    private final static void setBoolean(String key, Boolean value)
    {
        if (key != null)
        {
            sharedPreferences = MobappApplicationState.getInstance().getCurrentActiveContext().getSharedPreferences(MobappConstant.MOBAPP_SHARED_PREFERENCES_USER, Context.MODE_PRIVATE);
            spEditor = sharedPreferences.edit();
            spEditor.putBoolean(key, value);
            spEditor.commit();
        }
    }

    // ============================================================================================
    // Clear Shared Preferences
    // ============================================================================================

    public final static void clearAll()
    {
        sharedPreferences = MobappApplicationState.getInstance().getCurrentActiveContext().getSharedPreferences(MobappConstant.MOBAPP_SHARED_PREFERENCES_USER, Context.MODE_PRIVATE);
        spEditor = sharedPreferences.edit();
        spEditor.clear();
        spEditor.commit();
    }

    public final static void clear(String key)
    {
        if (key != null)
        {
            sharedPreferences = MobappApplicationState.getInstance().getCurrentActiveContext().getSharedPreferences(MobappConstant.MOBAPP_SHARED_PREFERENCES_USER, Context.MODE_PRIVATE);
            spEditor = sharedPreferences.edit();
            spEditor.remove(key);
            spEditor.commit();
        }
    }
}
