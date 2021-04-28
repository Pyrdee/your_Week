package com.example.your_week;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class List_Of_Activities extends AppCompatActivity {

    RecyclerView recyclerView;
    private TextView stars;
    private StarPoints starPoints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_activities);

        //Esitellään ruutu, johon päivittyvät tiedot tähtien määrästä.
        stars = findViewById(R.id.tv_StarValue);
        //Kerrotaan alkuarvot. Alkuarvo = 0 ja uuden tähtipisteen määrä = 1.
        starPoints = new StarPoints(0, 1);
        update();

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

    public void reset(View view) {
        starPoints.reset();
        update();
    }

    public void plus() {
        starPoints.plusStar();
        Log.d("call", "Hits: ");
        update();
    }

    private void update() {
        stars.setText(Integer.toString(starPoints.getValue()));
        SharedPreferences pref = getSharedPreferences("SharedPreference",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = pref.edit();
        prefEditor.putInt("starPoints", starPoints.getValue());


        prefEditor.commit();
    }

}
