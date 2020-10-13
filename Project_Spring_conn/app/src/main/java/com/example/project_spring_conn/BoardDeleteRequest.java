package com.example.project_spring_conn;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BoardDeleteRequest extends StringRequest {
    final static  private String URL = "http://192.168.123.104:8088/span/mDelete";

    private Map<String, String> parameters;


    public BoardDeleteRequest(String num, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("num",num);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
