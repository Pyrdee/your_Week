package com.example.your_week;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List_Of_Activities extends AppCompatActivity {

    Tehtava tehtava;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_activities);

        ListView listView = (ListView) findViewById(R.id.lvTehtavat);
        tehtava = new Tehtava(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = tehtava.getListContents();

        if(data.getCount() == 0) {
            Toast.makeText(List_Of_Activities.this, "Tehtävälista on tyhjä", Toast.LENGTH_LONG).show();

        } else{
            while(data.moveToNext()) {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}