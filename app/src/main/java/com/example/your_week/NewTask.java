package com.example.your_week;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewTask extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "your_Week.task";
    public static final String EXTRA_MESSAGE2 = "your_Week.time";
    public static final String EXTRA_MESSAGE3 = "your_Week.Date";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);
    }
    public void createNewTask (View view) {
        Intent taskCreate = new Intent(this, TODO);
        EditText editname = (EditText) findViewById(R.id.ptTaskName);
        String name = editname.getText().toString();
        EditText editdate = (EditText) findViewById(R.id.ptTaskDate);
        String date = editdate.getText().toString();
        EditText edittime = (EditText) findViewById(R.id.ptTaskTime);
        String time = edittime.getText().toString();
        taskCreate.putExtra(EXTRA_MESSAGE, name);
        taskCreate.putExtra(EXTRA_MESSAGE2, date);
        taskCreate.putExtra(EXTRA_MESSAGE3, time);
        startActivity(taskCreate);

    }


}
