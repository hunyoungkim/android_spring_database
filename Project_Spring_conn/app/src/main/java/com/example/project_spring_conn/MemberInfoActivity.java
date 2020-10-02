package com.example.project_spring_conn;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MemberInfoActivity extends TabActivity {

    TextView m_id, m_name, m_phonenumber, m_address, m_email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        m_id = (TextView) findViewById(R.id.m_id);
        m_name = findViewById(R.id.m_name);
        m_phonenumber = findViewById(R.id.m_phonenumber);
        m_address = findViewById(R.id.m_address);
        m_email = findViewById(R.id.m_email);

        Intent intent = getIntent();

        try {
            JSONObject jsonResponse = new JSONObject(intent.getStringExtra("json"));
            m_id.setText("ID :\n" + jsonResponse.getString("m_id"));
            m_name.setText("NAME :\n" + jsonResponse.getString("m_name"));
            m_phonenumber.setText("PHONE :\n" + jsonResponse.getString("m_phonenumber"));
            m_email.setText("E-MAIL :\n" + jsonResponse.getString("m_email"));
            m_address.setText("ADDRESS :\n" + jsonResponse.getString("m_address"));

            Log.v("아이디", jsonResponse.getString("m_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


            TabHost tabHost = getTabHost();

            TabHost.TabSpec tabSpecProduct = tabHost.newTabSpec("Product").setIndicator("Product");
            tabSpecProduct.setContent(R.id.tabProduct);
            tabHost.addTab(tabSpecProduct);

            TabHost.TabSpec tabSpecMember = tabHost.newTabSpec("Member").setIndicator("MyPage");
            tabSpecMember.setContent(R.id.tabMember);
            tabHost.addTab(tabSpecMember);

            TabHost.TabSpec tabSpecQna = tabHost.newTabSpec("Qna").setIndicator("Q & A");
            tabSpecQna.setContent(R.id.tabQna);
            tabHost.addTab(tabSpecQna);

            tabHost.setCurrentTab(0);


    }
}