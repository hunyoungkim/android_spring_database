package com.example.project_spring_conn;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//로그인 요청

public class LoginRequest extends StringRequest{
    final static  private String URL = "http://192.168.123.104:8088/span/mLogin";
    private Map<String, String> parameters;

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("m_id",userID);
        parameters.put("m_password",userPassword);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}

