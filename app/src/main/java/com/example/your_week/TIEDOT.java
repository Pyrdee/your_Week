package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TIEDOT extends AppCompatActivity {
    String ptUserName, ptUserAge, ptUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);
    TextView name_user, age_user, email_user;

    name_user =findViewById(R.id.ptUserName);
    age_user = findViewById(R.id.ptUserAge);
    email_user = findViewById(R.id.ptUserEmail);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserData", MODE_PRIVATE);
        String name = sharedPreferences.getString(ptUserName, "");
        String age = sharedPreferences.getString(ptUserAge, "");
        String email = sharedPreferences.getString(ptUserEmail, "");

        name_user.setText(name);
        age_user.setText(age);
        email_user.setText(email);

    ImageView calendar = findViewById(R.id.bt_calendar);
    ImageView newTask = findViewById(R.id.bt_newTask);
    ImageView myProfile = findViewById(R.id.bt_myProfile);

    calendar.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent1 = new Intent(TIEDOT.this, List_Of_Activities.class);
            startActivity(intent1);
        }
    });

    newTask.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent2 = new Intent(TIEDOT.this, NewTask.class);
            startActivity(intent2);
        }
    });
    myProfile.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent2 = new Intent(TIEDOT.this, TIEDOT.class);
            startActivity(intent2);
        }
    });

    }
}

