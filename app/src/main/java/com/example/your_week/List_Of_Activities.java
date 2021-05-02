package com.example.your_week;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.your_week.Stars.COUNT;

public class List_Of_Activities extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView starValue;
    Button addStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_activities);

        //Asetetaan muuttujille arvot widgeteistä.
        starValue = findViewById(R.id.tv_StarValue);
        addStar = findViewById(R.id.button);


        final SharedPreferences prefs = List_Of_Activities.this.getSharedPreferences(Stars.PREFS_KEY, Context.MODE_PRIVATE);
        //Luodaan uusi tieto nimeltä count, alkuarvoksi asetetaan nolla
        final int count = prefs.getInt(COUNT, 0);

        //Näytetään arvo textviewissä
        starValue.setText(String.valueOf(count));

        addStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = prefs.getInt(Stars.COUNT, 0);

                //Jaettujen asetusten lisääminen, tallentaminen ja näytön päivittäminen.
                prefs.edit().putInt(Stars.COUNT, (value + 1)).apply();
                int refreshedValue = prefs.getInt(Stars.COUNT, 0);
                starValue.setText(String.valueOf(refreshedValue));
            }
        });

        //Esitellään recycleview widgetti muuttujalle.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        TaskDataHelper taskDataHelper = new TaskDataHelper(this);
        List<TaskModel> taskModels = taskDataHelper.getTaskList();
        //Tarkistetaan onko listalla objekteja, jos on asetetaan ne recycleviewiin.
        if (taskModels.size() > 0) {
            TaskAdapterClass taskAdapterClass = new TaskAdapterClass(taskModels, List_Of_Activities.this);
            recyclerView.setAdapter(taskAdapterClass);
            //Jos listalla ei ole mitään, annetaan toasti: Aloita lisäämällä uusi tehtävä!
        } else {
            Toast.makeText(this, "Aloita lisäämällä uusi tehtävä yläpalkin plus-merkistä!", Toast.LENGTH_LONG).show();
        }


        // upbarissa olevat komponentit:
        ImageView calendar = findViewById(R.id.bt_calendar);
        ImageView newTask = findViewById(R.id.bt_newTask);
        ImageView myProfile = findViewById(R.id.bt_myProfile);

        calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(List_Of_Activities.this, List_Of_Activities.class);
                startActivity(intent1);
            }
        });

        newTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(List_Of_Activities.this, NewTask.class);
                startActivity(intent2);
            }
        });
        myProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(List_Of_Activities.this, UserInfo.class);
                startActivity(intent3);
            }
        });
    }


}