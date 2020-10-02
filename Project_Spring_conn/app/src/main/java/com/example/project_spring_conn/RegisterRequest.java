package com.example.project_spring_conn;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//회원가입 요청

public class RegisterRequest extends StringRequest {

    final static  private String URL = "http://192.168.123.104:8088/span/mminsert";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName, String userTel, String userEmail, String userAddress, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("m_id",userID);
        parameters.put("m_password",userPassword);
        parameters.put("m_name",userName);
        parameters.put("m_phonenumber",userTel);
        parameters.put("m_email",userEmail);
        parameters.put("m_address",userAddress);
        parameters.put("mobile", "true");
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
