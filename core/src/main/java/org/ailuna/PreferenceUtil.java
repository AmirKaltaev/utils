package org.ailuna;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {

    public static final String LANGUAGE = "LANGUAGE";
    public static final String USER_LOGIN = "USER_LOGIN";
    public static final String FCM_TOKEN = "FCM_TOKEN";
    public static final String TOKEN_IS_NEW = "TOKEN_IS_NEW";

    private static final String MAIN_APP_PREFERENCES = "MAIN_APP_PREFERENCES";
    private static SharedPreferences instance;

    public static synchronized SharedPreferences getInstance(Context context) {
        if (instance == null) {
            instance = context.getSharedPreferences(MAIN_APP_PREFERENCES, 0) ;
        }
        return instance;
    }
}
