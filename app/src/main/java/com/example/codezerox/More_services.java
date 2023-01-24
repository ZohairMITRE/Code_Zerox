package com.example.codezerox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class More_services extends AppCompatActivity {
    Button sending,mps;
    EditText editTextSubject,editTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_services);

        //sending email
        editTextSubject=findViewById(R.id.edittxt_subject);
        editTextSubject=findViewById(R.id.edittxt_core);
        String to="mitrezouhair9@gmail.com";

        sending=findViewById(R.id.send);
        sending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = editTextSubject.getText().toString();
                String message = editTextSubject.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                try {
                    startActivity(Intent.createChooser(email, "Send mail..."));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(More_services.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }            }
        });
        //maps
        mps=findViewById(R.id.Maps);
        mps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(More_services.this, Maps.class));
            }
        });



    }
}