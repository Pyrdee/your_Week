package com.example.your_week;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewTask extends AppCompatActivity {

    Tehtava tehtavat;
    Button btSave;
    Button btView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        editText = (EditText) findViewById(R.id.ptTaskName);
        btSave = (Button) findViewById(R.id.btSave);

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewTask.this, List_Of_Activities.class);
                startActivity(intent);
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                } else {
                    Toast.makeText(NewTask.this, "Lisää tehtävä", Toast.LENGTH_LONG).show();
                }
            }
        });
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
                Intent intent2 = new Intent(NewTask.this, TIEDOT.class);
                startActivity(intent2);
            }
        });
    }


    public void AddData(String newEntry) {
        boolean insertData = tehtavat.addData(newEntry);

        if (insertData == true) {
            Toast.makeText(NewTask.this, "Tehtävä lisätty!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(NewTask.this, "Jotain meni pieleen", Toast.LENGTH_LONG).show();

        }
    }
}
