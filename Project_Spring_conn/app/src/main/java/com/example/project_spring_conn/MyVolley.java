package com.example.project_spring_conn;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyVolley {
    private static MyVolley minstance;
    private RequestQueue brequestQueue;

    public static MyVolley getInstance(Context context) {
        if(minstance == null)
            minstance = new MyVolley(context);
        return minstance;
    }

    MyVolley(Context context) {
        brequestQueue = Volley.newRequestQueue(context);
    }

    public RequestQueue getRequestQueue() {
        return brequestQueue;
    }
}
