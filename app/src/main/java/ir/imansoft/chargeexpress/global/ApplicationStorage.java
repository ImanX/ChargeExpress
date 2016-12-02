package ir.imansoft.chargeexpress.global;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class ApplicationStorage {

    private static ApplicationStorage instance;

    private static final String  STRING_DEF_VALUE  = null;
    private static final int     INTEGER_DEF_VALUE = 0;
    private static final boolean BOOLEAN_DEF_VALUE = false;

    private SharedPreferences        sharedPreferences;
    private SharedPreferences.Editor editor;


    public static ApplicationStorage getInstance(Context context) {
        if (instance == null) {
            instance = new ApplicationStorage(context);
        }
        return instance;
    }

    private ApplicationStorage(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = sharedPreferences.edit();
    }


    public void putString(String value, String key) {
        this.editor.putString(key, value);
        this.editor.apply();
    }

    public void putInt(int value, String key) {
        this.editor.putInt(key, value);
        this.editor.apply();
    }

    public void putBoolean(boolean value, String key) {
        this.editor.putBoolean(key, value);
        this.editor.apply();
    }


    public String getString(String key) {
        return this.sharedPreferences.getString(key, STRING_DEF_VALUE);
    }


    public Boolean getBoolean(String key) {
        return this.sharedPreferences.getBoolean(key, BOOLEAN_DEF_VALUE);
    }

    public int getInt(String key) {
        return this.sharedPreferences.getInt(key, INTEGER_DEF_VALUE);
    }


    public class Keys {
        public static final String USERNAME_KEY = "username";
    }


}


