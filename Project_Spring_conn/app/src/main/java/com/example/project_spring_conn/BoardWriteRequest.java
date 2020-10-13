package com.example.project_spring_conn;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BoardWriteRequest extends StringRequest {
    final static  private String URL = "http://192.168.123.104:8088/span/mWrite";

    private Map<String, String> parameters;

    public BoardWriteRequest(String m_id, String subject, String content, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("subject",subject);
        parameters.put("content",content);
        parameters.put("m_id",m_id);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
