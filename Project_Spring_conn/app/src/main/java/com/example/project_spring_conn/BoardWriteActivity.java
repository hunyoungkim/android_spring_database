package com.example.project_spring_conn;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class BoardWriteActivity extends AppCompatActivity  {

    private AlertDialog dialog1;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentin_dialog);

        showContent();

    }

    private void showContent() {
        final Dialog dialog = Utill.getCustomDialog(this, R.layout.contentin_dialog);


                    dialog.setCancelable(false);
                    dialog.show();

                    final EditText dialog_subject_in = dialog.findViewById(R.id.dialog_subject_in);
                    final EditText dialog_content_in = dialog.findViewById(R.id.dialog_content_in);

                    Button dialog_add = dialog.findViewById(R.id.dialog_add);


                    dialog_add.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String subject = dialog_subject_in.getText().toString();
                            String content = dialog_content_in.getText().toString();

                            if (subject.equals("") || content.equals("")) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(BoardWriteActivity.this);
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
                                            final AlertDialog.Builder builder = new AlertDialog.Builder(BoardWriteActivity.this);
                                            dialog1 = builder.setMessage("글 등록에 성공했습니다.")
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
                                            AlertDialog.Builder builder = new AlertDialog.Builder(BoardWriteActivity.this);
                                            dialog1 = builder.setMessage("글 등록에 실패했습니다.")
                                                    .setNegativeButton("확인", null)
                                                    .create();
                                            dialog1.show();
                                        }
                                    dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            };



                    String m_id = SaveSharedPreference.getUserId(BoardWriteActivity.this);
                    BoardWriteRequest boardWriteRequest = new BoardWriteRequest(m_id, subject, content, responseListener);
                    //BoardWriteRequest boardWriteRequest = new BoardWriteRequest(subject, content, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(BoardWriteActivity.this);
                    queue.add(boardWriteRequest);
                    }
        });

}

}
