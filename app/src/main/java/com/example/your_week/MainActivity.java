package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.your_week.Stars.COUNT;

public class MainActivity extends AppCompatActivity {

    TextView starValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Nämä koodirivit ovat jokaisessa luokassa, jossa näytetään tähtipisteiden määrä.
        //Tallennetaan textView widgetille oma muuttujanimi.
        starValue = findViewById(R.id.tv_StarValue);
        final SharedPreferences prefs = this.getSharedPreferences(Stars.PREFS_KEY, Context.MODE_PRIVATE);
        //Luodaan uusi tieto nimeltä count, alkuarvoksi asetetaan nolla
        final int count = prefs.getInt(COUNT, 0);
        //Asetetaan arvo textviewiin
        starValue.setText(String.valueOf(count));


        // Upbarissa olevat komponentit. Nämä kolme onClickListeneriä on laitettu jokaiselle luokalle,
        // johon on laitettu customUpBar. Ensimmäinen siirtää näkymän tehtävälistalle, toinen uuden tehtävän luontisivulle
        // ja kolmas omaan profiiliin.
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
                Intent intent3 = new Intent(MainActivity.this, UserInfo.class);
                startActivity(intent3);
            }
        });


    }

    // Tarkistetaan onko sharedPreferences lisätty tietoa, sen mukaan tekee päätöksen siitä mille sivulle siirrytään
    // Tässä tarkistetaan nimi-kenttä. Jos kenttä on tyhjä, siirrytään rekisteröinti-aktiviteettiin.
    public void moveForward(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);

        if (name != null) {
            Intent intent = new Intent(MainActivity.this, List_Of_Activities.class);
            startActivity(intent);
        } else {
            Intent moveToRegistration = new Intent(MainActivity.this, Registration.class);
            startActivity(moveToRegistration);
        }
    }
}