package com.example.your_week;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewTask extends AppCompatActivity {

    //Viitteet nappeihin ja muihin toimintoihin layoutissa
    Button btSaveTask;
    EditText editTask, editDate, editTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);


        btSaveTask = findViewById(R.id.btSaveNewTask);
        editTask = findViewById(R.id.ptTaskName);
        editDate = findViewById(R.id.ptTaskDate);
        editTime = findViewById(R.id.ptTaskTime);

        //Tallennusnapin tallennus
        btSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringTask = editTask.getText().toString();
                String stringDate = editDate.getText().toString();
                String stringTime = editTime.getText().toString();
                //Varmistetaan että kaikki kentät on täytetty.
                if (stringTask.length() <= 0 || stringDate.length() <= 0 || stringTime.length() <= 0) {
                    Toast.makeText(NewTask.this, "Täytä kaikki kentät!", Toast.LENGTH_SHORT).show();
                } else {
                    //Siirretään ruutuihin tallennetut tiedot addTask
                    TaskDataHelper taskDataHelper = new TaskDataHelper(NewTask.this);
                    TaskModel taskModel = new TaskModel(stringTask, stringDate, stringTime);
                    taskDataHelper.addTask(taskModel);
                    Toast.makeText(NewTask.this, "Uusi tehtävä lisätty!", Toast.LENGTH_SHORT).show();

                    finish();
                    startActivity(getIntent());
                }
            }
        });


        // upbarissa olevat komponentit
        ImageView calendar = findViewById(R.id.bt_calendar);
        ImageView newTask = findViewById(R.id.bt_newTask);
        ImageView myProfile = findViewById(R.id.bt_myProfile);

        calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(NewTask.this, List_Of_Activities.class);
                startActivity(intent1);
            }
        });
        newTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(NewTask.this, NewTask.class);
                startActivity(intent2);
            }
        });
        myProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(NewTask.this, UserInfo.class);
                startActivity(intent3);
            }
        });
    }


}
