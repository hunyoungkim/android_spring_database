package com.example.project_spring_conn;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class BoardAdapter extends BaseAdapter {
    private Context context;
    private List<BoardData> boardList;

    public BoardAdapter(List<BoardData> boardList) {
        this.boardList = boardList;

    }

    @Override
    public int getCount() {
        Log.d("겟카운트", String.valueOf(boardList.size()));
        return this.boardList.size();
    }



    @Override
    public Object getItem(int i) {
        return this.boardList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i; // ListView 위치(첫 번째 = 0)
        context = viewGroup.getContext();
        Log.d("어댑터 데이터", String.valueOf(pos));
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(inflater != null){
                view = inflater.inflate(R.layout.listview, viewGroup, false);
        }
        }
        TextView subject = view.findViewById(R.id.subject);
        TextView m_id = view.findViewById(R.id.m_id);
        final String num;
        Log.d("어댑터 데이터", "겠뷰아래");
        BoardData boardData = boardList.get(i);

        subject.setText(boardData.getSubject());

        m_id.setText(boardData.getM_id());
        num = String.valueOf(boardData.getNum());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 게시글 터치 시 내용 보여주는 다이얼로그 띄우기
                showContent(boardList.get(pos).getSubject(), boardList.get(pos).getContent(), boardList.get(pos).getM_id(), num);
            }
        });

        return view;
    }

    private void showContent(final String title, final String content, final String m_id, final String num) {
        final Dialog dialog = Utill.getCustomDialog(context, R.layout.content_dialog);
        // 8-9번 참고
        dialog.setCancelable(false);
        dialog.show();
        TextView dTitle = dialog.findViewById(R.id.dialog_title),
                dContent = dialog.findViewById(R.id.dialog_content);
        Button dClose = dialog.findViewById(R.id.dialog_close_img);
        Button bClose = dialog.findViewById(R.id.dialog_close);
        Button dialog_update = dialog.findViewById(R.id.dialog_update);
        Button dialog_delete = dialog.findViewById(R.id.dialog_delete);
        LinearLayout layout_dialog_buttons = dialog.findViewById(R.id.layout_dialog_buttons);
        //글 작성자와 로그인한 아이디가 동일하면 글수정, 글 삭제 버튼 활성화
        //String user = SaveSharedPreference.getUserId(context);
        if (m_id.equals(SaveSharedPreference.getUserId(context)) || SaveSharedPreference.getUserId(context).equals("admin")) {
            layout_dialog_buttons.setVisibility(View.VISIBLE);
        }

        dialog_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), BoardUpdateActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                intent.putExtra("m_id", m_id);
                intent.putExtra("num", num);
                context.startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), BoardDeleteActivity.class);
                intent.putExtra("num", num);
                context.startActivity(intent);
                dialog.dismiss();
            }
        });
        dTitle.setText(title);
        dContent.setText(content);
        dContent.setMovementMethod(new ScrollingMovementMethod());
        dClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        bClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
