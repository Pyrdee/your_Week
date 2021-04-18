package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registration extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
    public void getval(View view){
        EditText editText = (EditText) findViewById(R.id.ptName);
        EditText editText1 = (EditText) findViewById(R.id.ptAge);
        EditText editText2 = (EditText) findViewById(R.id.ptEmail);

        String text = editText.getText().toString();

        Intent intent = new Intent (this, TIEDOT.class);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
    }
}
