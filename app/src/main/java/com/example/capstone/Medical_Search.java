package com.example.capstone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class Search extends Activity {
    Button btn1, btn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg=new AlertDialog.Builder(Search.this);
                dlg.setTitle("도움말");
                dlg.setMessage("확인버튼을 누르면 카메라가 촬영을 시작합니다. " +
                        "휴대폰과 의약품 바코드 또는 OR 코드를 " +
                        "한 뼘 간격 만큼 정면을 향해 띄어주세요");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Search.this, "촬영을 시작합니다",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Search.this, "취소하셨습니다",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Search.this);
                dlg.setTitle("의약품 검색");

                final EditText input = new EditText(Search.this);
                dlg.setView(input);
                input.setHint("의약품명을 입력해주세요");
                dlg.setPositiveButton("검색", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String query = input.getText().toString().trim();
                        if (!query.isEmpty()) {
                            Intent intent = new Intent(Search.this, Text.class);
                            intent.putExtra("query", query);
                            startActivity(intent);
                            Toast.makeText(Search.this, "검색 완료: " + query, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Search.this, "검색어를 입력해주세요", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Search.this, "취소하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
    }
}