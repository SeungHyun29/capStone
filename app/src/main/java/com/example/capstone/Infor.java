package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Infor extends AppCompatActivity {
    Button inbtn1, inbtn2,inbtn3, inbtn4, inbtn5, inbtn6, inbtn7, inbtn8;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infor);

        String query = getIntent().getStringExtra("query");


        TextView queryTextView = findViewById(R.id.tv);
        if (query != null) {
            queryTextView.setText("의약품명: " + query);
        }

        inbtn1=(Button)findViewById(R.id.inbtn1);
        inbtn2=(Button)findViewById(R.id.inbtn2);
        inbtn3=(Button)findViewById(R.id.inbtn3);
        inbtn4=(Button)findViewById(R.id.inbtn4);
        inbtn5=(Button)findViewById(R.id.inbtn5);
        inbtn6=(Button)findViewById(R.id.inbtn6);
        inbtn7=(Button)findViewById(R.id.inbtn7);
        inbtn8=(Button)findViewById(R.id.inbtn8);
        ImageView bbtn2= findViewById(R.id.bbtn2);
        bbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Infor.this, Text.class);
                startActivity(intent);
            }
        });
    }
}
