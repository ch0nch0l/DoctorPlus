package net.zeroit.vortexzero.doctorplus.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Chonchol on 16-Aug-16.
 */
public class AppPrefManager {
    Context appContext;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    int MODE_PRIVATE = 0;

    private static String PREF_NAME = "doctor-plus";
    private static String IS_FIRST_TIME = "FirstTimeLunch";

    public AppPrefManager(Context context) {
        this.appContext = context;
        this.preferences = appContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        this.editor = preferences.edit();
    }

    public void setIsFirstTime(boolean isFirstTime){
        editor.putBoolean(IS_FIRST_TIME, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLunch(){
        return preferences.getBoolean(IS_FIRST_TIME, true);
    }
}

