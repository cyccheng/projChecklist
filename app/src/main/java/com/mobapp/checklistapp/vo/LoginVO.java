package com.mobapp.checklistapp.vo;

/**
 * Created by sherynn on 27/03/2018.
 */

public class LoginVO extends Object
{
    private String userID;
    private String password;
    private String userIdentity;
    private String status;

    // ============================================================================================
    // Getter & Setter
    // ============================================================================================

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserIdentity()
    {
        return userIdentity;
    }

    public void setUserIdentity(String identity)
    {
        this.userIdentity = identity;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
