package com.example.helloworld;

import android.content.Context;
import android.content.SharedPreferences;

public class LogInCheck {
    public static final String Loginapplication = "Application";

    public static final String LoginUsername = "Nama";
    public static final String LoginEmail = "Email";

    public static final String LoggedIn = "Logged In";
    private static SharedPreferences.Editor spEditor;
    private static SharedPreferences sp;

    public LogInCheck(Context context){
        sp = context.getSharedPreferences(Loginapplication, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public static void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getLoginUsername(){
        return sp.getString(LoginUsername, "");
    }

    public String getLoginEmail(){
        return sp.getString(LoginEmail, "");
    }

    public static Boolean getLoggedIn(){
        return sp.getBoolean(LoggedIn, false);
    }
}
