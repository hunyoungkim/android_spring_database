package com.example.project_spring_conn;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


//회원 아이디 체크(회원가입이 가능한 아이디인지)

public class ValidateRequest extends StringRequest {

    final static  private String URL = "http://192.168.123.104:8088/span/midcheck";
    private Map<String, String> parameters;


    public ValidateRequest(String userID, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("id",userID);
        Log.v("아이디",userID.toString());
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
