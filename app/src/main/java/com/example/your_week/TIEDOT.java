package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TIEDOT extends AppCompatActivity {
    TextView text_name, text_age, text_email;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "userData";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);
        // alustus
        text_name = findViewById(R.id.ptUserName);
        text_age = findViewById(R.id.ptUserAge);
        text_email = findViewById(R.id.ptUserEmail);

        // tietojen haku käyttäen shared prefs
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        String age = sharedPreferences.getString(KEY_AGE, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if (name != null || age != null || email != null) {
            text_name.setText("" + name);
            text_age.setText("" + age);
            text_email.setText("" + email);
        }

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

