package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TIEDOT extends AppCompatActivity {


@Override

    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_t_i_e_d_o_t);


    TextView text =(TextView) findViewById(R.id.ptUserName);
    TextView tex =(TextView) findViewById(R.id.ptUserAge);
    TextView te =(TextView) findViewById(R.id.ptUserEmail);

    Intent actIntent = getIntent();

    String name = actIntent.getExtras().getString(Registration.EXTRA_TEXT);
    String age = actIntent.getExtras().getString(Registration.EXTRA_TEXT1);
    String Email = actIntent.getExtras().getString(Registration.EXTRA_TEXT2);

    text.setText(name);
    tex.setText(age);
    te.setText(Email);


    }
}

