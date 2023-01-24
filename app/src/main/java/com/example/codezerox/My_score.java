package com.example.codezerox;
import android.content.ActivityNotFoundException;
import android.os.Bundle;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.widget.*;


public class My_score extends AppCompatActivity {
    Button btn1,btn2,Mores;
    EditText editTextSubject,editTextMessage;
    com.github.lzyzsd.circleprogress.DonutProgress ProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_score);

        int score= getIntent().getIntExtra("score",0);

        ProgressBar=findViewById(R.id.progress_bar);
        ProgressBar.setProgress(score);
        //More services
        Mores=findViewById(R.id.send);
        Mores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(My_score.this, More_services.class));
            }
        });
        //Try again
        btn2=findViewById(R.id.button3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(My_score.this, Question1.class));
            }
        });
        //Logout
        btn1=findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(My_score.this, MainActivity.class));
            }
    });

    }
    @Override
    public void onBackPressed() {
        Toast.makeText(My_score.this, "Impossible to go back.",
                Toast.LENGTH_SHORT).show();
    }
}