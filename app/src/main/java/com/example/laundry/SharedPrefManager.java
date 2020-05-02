package com.example.laundry;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_LAUNDRY_APP = "spLaundryApp";
    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences pref;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        pref = context.getSharedPreferences(SP_LAUNDRY_APP, Context.MODE_PRIVATE);
        spEditor = pref.edit();
    }
    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public Boolean getSPSudahLogin(){
        return pref.getBoolean(SP_SUDAH_LOGIN, false);
    }

}
