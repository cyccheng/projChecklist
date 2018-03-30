package com.mobapp.checklistapp.util;

import junit.framework.Assert;

/**
 * Created by sherynn on 30/03/2018.
 */

public class MobappUtil
{
    private static MobappUtil instance = null;

    // ============================================================================================
    // Constructors
    // ============================================================================================

    public MobappUtil()
    {
        Assert.assertTrue("Duplication of singleton instance", instance == null);
    }

    public final static MobappUtil getInstance()
    {
        if (instance == null)
        {
            synchronized (MobappUtil.class)
            {
                if (instance == null)
                {
                    instance = new MobappUtil();
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

    public void encryptString() {

    }

    public void decryptString() {

    }
}