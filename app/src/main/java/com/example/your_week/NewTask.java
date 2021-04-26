package com.example.your_week;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NewTask extends AppCompatActivity {

    //Viitteet nappeihin ja muihin toimintoihin layoutissa
    Button btSaveTask;
    EditText editTask, editDate, editTime;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);


        btSaveTask = findViewById(R.id.btSaveNewTask);
        editTask = findViewById(R.id.ptTaskName);
        editDate = findViewById(R.id.ptTaskDate);
        editTime = findViewById(R.id.ptTaskTime);

        Calendar pickedDate = Calendar.getInstance();
        final int year = pickedDate.get(Calendar.YEAR);
        final int month = pickedDate.get(Calendar.MONTH);
        final int day = pickedDate.get(Calendar.DAY_OF_MONTH);

        editDate.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(NewTask.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
    });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"."+month+"."+year;
                editDate.setText(date);
            }
        };

        //Tallennusnapin tallennus
        btSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringTask = editTask.getText().toString();
                String stringDate = editDate.getText().toString();
                String stringTime = editTime.getText().toString();


                //Varmistetaan että kaikki kentät on täytetty.

                //Varmistetaan että kaikki kentät on täytetty, jos ei ole näytölle tulee Toast

                if (stringTask.length() <= 0 || stringDate.length() <= 0 || stringTime.length() <= 0) {
                    Toast.makeText(NewTask.this, "Täytä kaikki kentät!", Toast.LENGTH_SHORT).show();
                } else {
                    //Siirretään ruutuihin tallennetut tiedot addTask
                    TaskDataHelper taskDataHelper = new TaskDataHelper(NewTask.this);
                    TaskModel taskModel = new TaskModel(stringTask, stringDate, stringTime);
                    taskDataHelper.addTask(taskModel);
                    Toast.makeText(NewTask.this, "Uusi tehtävä lisätty!", Toast.LENGTH_SHORT).show();

                    finish();
                    Intent intent = new Intent(NewTask.this, List_Of_Activities.class);
                    startActivity(intent);
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
