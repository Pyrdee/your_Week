package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TIEDOT extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);

     getSharedPreferences("UserData", MODE_PRIVATE);

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
