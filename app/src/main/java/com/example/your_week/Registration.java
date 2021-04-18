package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    public static final String EXTRA_TEXT = "name";
    public static final String EXTRA_TEXT1 = "age";
    public static final String EXTRA_TEXT2 = "email";

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registration);
}
    public void SendValues(View view) {


        EditText editText = (EditText) findViewById(R.id.ptName);
        EditText editText1 = (EditText) findViewById(R.id.ptAge);
        EditText editText2 = (EditText) findViewById(R.id.ptEmail);


        String text = editText.getText().toString();
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();

        Intent intent = new Intent(this, TIEDOT.class);

        intent.putExtra(EXTRA_TEXT, text);
        intent.putExtra(EXTRA_TEXT1, text1);
        intent.putExtra(EXTRA_TEXT2, text2);

        startActivity(intent);
    }
}
