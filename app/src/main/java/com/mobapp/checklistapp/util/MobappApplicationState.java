package com.mobapp.checklistapp.util;

import android.app.Activity;
import android.content.Context;
import junit.framework.Assert;

/**
 * Created by sherynn on 27/03/2018.
 */

public class MobappApplicationState
{
    private static MobappApplicationState instance = null;
    private Activity currentActivity = null;
    private Context currentActiveContext = null;

    // ============================================================================================
    // Constructors
    // ============================================================================================

    public MobappApplicationState()
    {
        Assert.assertTrue("Duplication of singleton instance", instance == null);
    }

    public final static MobappApplicationState getInstance()
    {
        if (instance == null)
        {
            synchronized (MobappApplicationState.class)
            {
                if (instance == null)
                {
                    instance = new MobappApplicationState();
                }
            }
        }

        return instance;
    }

    // ============================================================================================
    // Getter & Setter
    // ============================================================================================

    public Activity getCurrentActivity()
    {
        return currentActivity;
    }

    public void setCurrentActivity(Activity currentActivity)
    {
        this.currentActivity = currentActivity;
    }

    public Context getCurrentActiveContext()
    {
        return currentActiveContext;
    }

    public void setCurrentActiveContext(Context currentActiveContext)
    {
        this.currentActiveContext = currentActiveContext;
    }

    // ============================================================================================
    // Public Methods
    // ============================================================================================

    public final static void resetInstance()
    {
        instance = null;
    }

    public final static void resetInitData()
    {
        if (instance != null)
        {

        }

        //clear any data
    }
}