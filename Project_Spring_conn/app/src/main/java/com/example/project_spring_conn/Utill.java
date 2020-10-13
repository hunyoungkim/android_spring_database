package com.example.project_spring_conn;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;

public class Utill {

    public static Dialog getCustomDialog(Context context, int layout) {
        Dialog dialog = new Dialog(context);
        Log.d("여기 들어오나?", String.valueOf(layout));
        dialog.setContentView(layout);
        return dialog;
    }
    public static void showToast(Context mContext, String 에러에러) {
    }
}
