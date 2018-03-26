package com.mobapp.checklistapp.util;

import android.widget.Button;
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

    public void setBtnEnabled(Button button, Boolean enabled)
    {
        button.setEnabled(enabled);

        if (enabled)
        {
            button.setAlpha(1.0f);
        }
        else
        {
            button.setAlpha(0.4f);
        }
    }

    // ============================================================================================
    // Private Methods
    // ============================================================================================

}