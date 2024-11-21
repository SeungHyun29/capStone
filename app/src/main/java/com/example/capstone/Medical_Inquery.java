package com.example.capstone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Text extends AppCompatActivity {
    Button nbtn, nbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        String query = getIntent().getStringExtra("query");
        TextView textview = findViewById(R.id.txt);
        textview.setText("의약품명: " + query);

        textview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Text.this, Infor.class);
                intent.putExtra("query",query);
                startActivity(intent);
            }
        });
        nbtn = (Button) findViewById(R.id.nbtn);
        nbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newsUrl = "https://search.naver.com/search.naver?where=news&query=" + query;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl));
                startActivity(browserIntent);
            }
        });
        nbtn2 = (Button)findViewById(R.id.nbtn2);
        nbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newsUrl = "https://search.naver.com/search.naver?where=news&query=" + query + " 부작용";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl));
                startActivity(browserIntent);
            }
        });
        ImageView bbtn= findViewById(R.id.bbtn);
        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Text.this, Search.class);
                startActivity(intent);
            }
        });
    }
}