package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TIEDOT extends AppCompatActivity {

@Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_i_e_d_o_t);
        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);
    String text1 = intent.getStringExtra(Intent.EXTRA_TEXT);
    String text2 = intent.getStringExtra(Intent.EXTRA_TEXT);

    TextView textView = (TextView) findViewById(R.id.NAME);
    TextView tView = (TextView) findViewById(R.id.AGE);
    TextView teView = (TextView) findViewById(R.id.EMAIL);

    textView.setText(text);
    tView.setText(text1);
    teView.setText(text2);







        }
    }

