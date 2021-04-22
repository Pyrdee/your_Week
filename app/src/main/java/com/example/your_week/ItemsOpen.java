package com.example.your_week;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemsOpen extends AppCompatActivity {
    ListView listView;

    String []listitems = new String[]{
            "Tehtävä 1",
            "Tehtävä 2",
            "Tehtävä 3",
            "Tehtävä 4",
            "Tehtävä 5",
            "Tehtävä 6",
            "Tehtävä 7",
            "Tehtävä 8",
            "Tehtävä 9",
            "Tehtävä 10"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_activities);

        listView = findViewById(R.id.lvTehtavat);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(ItemsOpen.this, android.R.layout.simple_list_item_1);
         listView.setAdapter(adapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String listview = listitems[position].toString();
                 Intent intent = new Intent(ItemsOpen.this, NewTask.class);
                 intent.putExtra("Listclick", listview);
                 startActivity(intent);
             }
         });

    }
}
