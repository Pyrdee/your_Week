package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity {


    //public static final String "EXTRA MESSAGE" = "com.example.your_Week.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }
       public void getval(View view){
           EditText editText= (EditText) findViewById(R.id.ptName);
           EditText editText1= (EditText) findViewById(R.id.ptAge);
           EditText editText2= (EditText) findViewById(R.id.ptEmail);

           String text =editText.getText().toString();
           String tex = editText1.getText().toString();
           String te = editText2.getText().toString();

           Intent intent = new Intent(this, TIEDOT.class);
           intent.putExtra(Intent.EXTRA_TEXT, text);
           intent.putExtra(Intent.EXTRA_TEXT, tex);
           intent.putExtra(Intent.EXTRA_TEXT, te);


           startActivity(intent);


    }
}
