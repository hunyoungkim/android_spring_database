package com.example.project_spring_conn;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class BoardDeleteActivity extends AppCompatActivity {

    private AlertDialog dialog, dialog1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentupdate_dialog);

        Intent intent = getIntent();
        final String num = intent.getExtras().getString("num");

        final AlertDialog.Builder builder = new AlertDialog.Builder(BoardDeleteActivity.this);
        dialog = builder.setMessage("글을 삭제 하시겠습니까?")
                .setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton){
                        dialog.dismiss();
                        finish();
                    }
                })
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteContent(num);
                        dialog.dismiss();
                        finish();
                    }
                }).create();

        dialog.show();
    }

    private void deleteContent(final String num) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.P)
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            Log.d("여기 들어오나요?", String.valueOf(success));
                            if (success) {
                                Log.d("여기 들어오나요?", "???????");
                                MemberInfoActivity.getBoardData();
                                Toast.makeText(getApplicationContext(),"글을 삭제했습니다.", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(getApplicationContext(),"글을 삭제에 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                };

                BoardDeleteRequest boardDeleteRequest = new BoardDeleteRequest(num, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BoardDeleteActivity.this);
                queue.add(boardDeleteRequest);
            }


}
