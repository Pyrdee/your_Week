package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TIEDOT extends AppCompatActivity {


@Override

    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_tiedot);

    // Tietojen haku sharedpreferencestä
    SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
    getSharedPreferences("UserData", MODE_PRIVATE);
    /**
    SharedPreferences age = getSharedPreferences("age", MODE_PRIVATE);
    SharedPreferences email = getSharedPreferences("email", MODE_PRIVATE);

    Intent actIntent = getIntent();
    TextView usname =(TextView) findViewById(R.id.ptUserName);
    TextView usage =(TextView) findViewById(R.id.ptUserAge);
    TextView usemail =(TextView) findViewById(R.id.ptUserEmail);

    SharedPreferences user_age = getSharedPreferences("age", MODE_PRIVATE);
    SharedPreferences user_name = getSharedPreferences("name", MODE_PRIVATE);
    SharedPreferences user_email = getSharedPreferences("email", MODE_PRIVATE);
     **/

    // upbarissa olevat komponentit
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
            Intent intent3 = new Intent(TIEDOT.this, TIEDOT.class);
            startActivity(intent3);
        }
    });

    }
}

