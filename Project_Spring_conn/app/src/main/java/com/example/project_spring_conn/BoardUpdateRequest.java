package com.example.project_spring_conn;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BoardUpdateRequest extends StringRequest {
    final static  private String URL = "http://192.168.123.104:8088/span/mUpdate";

    private Map<String, String> parameters;


    public BoardUpdateRequest(String m_id, String subject, String content, String num, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("subject",subject);
        parameters.put("content",content);
        parameters.put("m_id",m_id);
        parameters.put("num",num);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
