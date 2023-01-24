package com.example.codezerox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class question4 extends AppCompatActivity {

    Button B1,speaker;
    RadioGroup radioGroup;
    RadioButton radioButton;
    private TextToSpeech mTTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        //ajouter un compteur
        CountDownTimer CDT = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                ((TextView)findViewById(R.id.TimerShow)).setText((millisUntilFinished / 1000)+" s");

            }

            public void onFinish() {
                startActivity(new Intent(question4.this,question5.class));
            }
        }.start();
        //------------------------------------------

        B1=findViewById(R.id.button2);
        radioGroup=findViewById(R.id.rdg1);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(selected);
                String str=radioButton.getText().toString();
                int score= getIntent().getIntExtra("score",0);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getWidth(), view.getHeight());
                if(str.equals("Le tramway circule")){
                    score+=20;
                    startActivity(new Intent(question4.this,question5.class).putExtra("score",score), options.toBundle());
                    CDT.cancel();
                }
                startActivity(new Intent(question4.this,question5.class).putExtra("score",score), options.toBundle());
                CDT.cancel();
            }
        });

        speaker=findViewById(R.id.speak1);
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.FRENCH);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });
        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });


    }
    @Override
    public void onBackPressed() {
        Toast.makeText(question4.this, "Impossible to go back.",
                Toast.LENGTH_SHORT).show();
    }
    //la methode qui permet la lecture du question
    private void speak() {
        TextView text = findViewById(R.id.textView2);
        String convText = text.getText().toString();
        float pitch = 1;
        float speed = 0.8f;
        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);
        // mTTS.speak(convText, TextToSpeech.QUEUE_FLUSH, null);
        //HashMap<String, String> params = new HashMap<String, String>();
        //params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"stringId");
        mTTS.speak(convText+"   réponse numéro 1    Le tramway est arrete ,   réponse numéro 2    Le tramway circule",TextToSpeech.QUEUE_FLUSH,null,null);
    }
}