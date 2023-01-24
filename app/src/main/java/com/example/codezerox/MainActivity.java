package com.example.codezerox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
//import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        login=findViewById(R.id.button);
        register=findViewById(R.id.textView);

        login.setOnClickListener(view -> {
            String mail = email.getText().toString();
            String pw = password.getText().toString();
            mAuth.signInWithEmailAndPassword(mail, pw)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            Log.d("OpStatusLoginSuccess", "signInWithEmail:success");
                            startActivity(new Intent(MainActivity.this, Question1.class));
                        } else {
                            Log.w("OpStatusLoginFail", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        register.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Register.class);
            startActivity(intent);
        });

    }
    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this, "Impossible to go back.",
                Toast.LENGTH_SHORT).show();
    }
}