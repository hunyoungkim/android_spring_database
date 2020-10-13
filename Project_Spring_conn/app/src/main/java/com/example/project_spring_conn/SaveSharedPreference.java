package com.example.project_spring_conn;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveSharedPreference {


    static final String PREF_USER_NAME = "m_id";

    static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    // 계정 정보 저장
    public static void setUserId(Context context, String m_id) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_USER_NAME, m_id);
        editor.commit();
    }

    // 저장된 정보 가져오기
    public static String getUserId(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    // 로그아웃
    public static void clearUserId(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.commit();
    }
}
