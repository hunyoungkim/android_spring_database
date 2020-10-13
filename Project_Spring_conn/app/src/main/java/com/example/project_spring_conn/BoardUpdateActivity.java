package com.example.project_spring_conn;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class BoardUpdateActivity extends AppCompatActivity {

    private AlertDialog dialog1;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentupdate_dialog);

        Intent intent = getIntent();
        String subject = intent.getExtras().getString("title");
        String content = intent.getExtras().getString("content");
        String m_id = intent.getExtras().getString("m_id");
        String num = intent.getExtras().getString("num");

        showContent(subject, content, m_id, num);

    }

    private void showContent(String subject, String content, String m_id, final String num) {
        final Dialog dialog = Utill.getCustomDialog(this, R.layout.contentupdate_dialog);

        // 8-9번 참고
        dialog.setCancelable(false);
        dialog.show();


        final EditText dialog_subject_update = dialog.findViewById(R.id.dialog_subject_update);
        final EditText dialog_content_update = dialog.findViewById(R.id.dialog_content_update);
        dialog_subject_update.setText(subject);
        dialog_content_update.setText(content);
        Button dialog_update = dialog.findViewById(R.id.dialog_update);


        dialog_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = dialog_subject_update.getText().toString();
                String content = dialog_content_update.getText().toString();

                if (subject.equals("") || content.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BoardUpdateActivity.this);
                    AlertDialog dialog1 = builder.setMessage("빈 칸 없이 입력해주세요.")
                            .setNegativeButton("확인", null)
                            .create();
                    dialog1.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.P)
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                final AlertDialog.Builder builder = new AlertDialog.Builder(BoardUpdateActivity.this);
                                dialog1 = builder.setMessage("글 수정에 성공했습니다.")
                                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                MemberInfoActivity.getBoardData();
                                                finish();
                                            }
                                        })
                                        .create();
                                dialog1.show();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(BoardUpdateActivity.this);
                                dialog1 = builder.setMessage("글 수정에 실패했습니다.")
                                        .setNegativeButton("확인", null)
                                        .create();
                                dialog1.show();

                            }
                            //dialog.dismiss();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                };

                String m_id = SaveSharedPreference.getUserId(BoardUpdateActivity.this);
                BoardUpdateRequest boardUpdateRequest = new BoardUpdateRequest(m_id, subject, content, num, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BoardUpdateActivity.this);
                queue.add(boardUpdateRequest);
            }
        });

    }

}
