package com.example.project_spring_conn;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MemberInfoActivity extends TabActivity {

    TextView m_id, m_name, m_phonenumber, m_address, m_email;
    static Context mContext;
    private static ListView mlistview;
    //private ProgressBar progressBar;
    Button updatebtn, writebtn, logout, logout1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        m_id = findViewById(R.id.m_id);
        m_name = findViewById(R.id.m_name);
        m_phonenumber = findViewById(R.id.m_phonenumber);
        m_address = findViewById(R.id.m_address);
        m_email = findViewById(R.id.m_email);
        mlistview = findViewById(R.id.listview1);
        //progressBar = findViewById(R.id.progressBar);
        mContext = this;
        updatebtn = findViewById(R.id.updatebtn);
        writebtn = findViewById(R.id.writebtn);
        logout = findViewById(R.id.logout);
        logout1 = findViewById(R.id.logout1);
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

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoardWriteActivity.class);
                startActivity(intent);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.clearUserId(mContext);
                Intent Intent = new Intent(MemberInfoActivity.this, LoginActivity.class);
                startActivity(Intent);

            }
        });
        logout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.clearUserId(mContext);
                Intent Intent = new Intent(MemberInfoActivity.this, LoginActivity.class);
                startActivity(Intent);

            }
        });
        getBoardData();
        tabHost.setCurrentTab(0);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBoardData();
            }
        });

    }
//    private void setProgressBar(int visibility) {
//        progressBar.setVisibility(visibility);
//    }

    public static void getBoardData() {
//        setProgressBar(View.VISIBLE);
        String url = "http://192.168.123.104:8088/span/boardlist"; // 서버사이드 페이지 웹 주소
        RequestQueue queue = AppController.getInstance(mContext).getbRequestQueue();
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, new JSONObject(),
                successListener(), errorListener());
        queue.add(jsonRequest);
    }

    public static void parsingJSONData(String data) {
        List<BoardData> mList = new ArrayList<>();
        Log.d("파싱json데이타", data);
        try {
            JSONArray jArray = new JSONArray(data);
            Log.d("포문 얼마나 도니?", String.valueOf(jArray.length()));
            for (int i = 0; i < jArray.length(); i++) {
                BoardData board = new BoardData();
                JSONObject jObject = jArray.getJSONObject(i);
                board.setNum(Integer.parseInt(jObject.getString("num")));
                board.setSubject(jObject.getString("subject"));
                board.setContent(jObject.getString("content"));
                board.setM_id(jObject.getString("m_id"));
                board.setWrite_date(jObject.getString("write_date"));
                mList.add(board);
                Log.d("파슬 제이슨", String.valueOf(mList));
            }
            Log.d("연결고리 전", "");
            mlistview.setAdapter(new BoardAdapter(mList));
            Log.d("연결고리 후", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static Response.Listener<JSONObject> successListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //setProgressBar(View.GONE);
                String result = null;
                try {
                    result = response.getString("data");
                    Log.d("데이터", result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                parsingJSONData(result);
            }
        };
    }

    public static Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("에러", "여기들어오면 안됨");
                //에러 메시지 작성
            }
        };
    }
}