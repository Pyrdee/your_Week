package com.example.your_week;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class List_Of_Activities extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_activities);


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
            Toast.makeText(this, "Aloita lisäämällä uusi tehtävä!", Toast.LENGTH_SHORT).show();
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
                Intent intent3 = new Intent(List_Of_Activities.this, TIEDOT.class);
                startActivity(intent3);
            }
        });
    }
}
