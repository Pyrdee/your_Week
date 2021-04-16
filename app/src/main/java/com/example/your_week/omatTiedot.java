package com.example.your_week;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class omatTiedot extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);

        TextView name, age, email;

        name = findViewById(R.id.ptName);
        age = findViewById(R.id.ptAge);
        email = findViewById(R.id.ptEmail);

        SharedPreferences shrd = getApplicationContext().getSharedPreferences("savefile", Context.MODE_PRIVATE);
        String ptName = shrd.getString("name", "");
        String ptEmail = shrd.getString("email", "");
        String ptAge = shrd.getString("age", "");

        name.setText(ptName);
        age.setText(ptAge);
        email.setText(ptEmail);


    }
}