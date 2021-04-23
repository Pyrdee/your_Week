package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // upbarissa olevat komponentit
        ImageView calendar = findViewById(R.id.bt_calendar);
        ImageView newTask = findViewById(R.id.bt_newTask);
        ImageView myProfile = findViewById(R.id.bt_myProfile);

        calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, List_Of_Activities.class);
                startActivity(intent1);
            }
        });

        newTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, NewTask.class);
                startActivity(intent2);
            }
        });
        myProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, TIEDOT.class);
                startActivity(intent3);
            }
        });



    }



    //Siirry eteenpäin. Katso löytyykö sharedprefences tiedostosta mitään. Jos löytyy, mene listanäkymään.
    //SharedPreferences sharedPreferences = getSharedPreferences("UserData",MODE_PRIVATE);

    public void moveForward(View view) {
        if (getSharedPreferences("UserData",MODE_PRIVATE) == null) {
            Intent moveToRegistration = new Intent(this, List_Of_Activities.class);
            startActivity(moveToRegistration);
        } else {
            Intent moveToRegistration = new Intent(this, Registration.class);
            startActivity(moveToRegistration);
        }
    }
}