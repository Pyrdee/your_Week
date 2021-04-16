package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
String name, email, age;



EditText ptName, ptEmail, ptAge;
Button btSave, button;
SharedPreferences shrd;

    public void moveToRegistration(View view){
        Intent move = new Intent(this, Registration.class);
        startActivity(move);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ptName = (EditText) findViewById(R.id.ptName);
        ptEmail = (EditText) findViewById(R.id.ptEmail);
        ptAge = (EditText) findViewById(R.id.ptAge);


        shrd = getSharedPreferences( "savefile", Context.MODE_PRIVATE);

        btSave = (Button) findViewById(R.id.btSave);
        button =  findViewById(R.id.button);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                name = ptName.getText().toString();
                email = ptEmail.getText().toString();
                age = ptAge.getText().toString();

                SharedPreferences.Editor editor =shrd.edit();

                editor.putString("nimi",name);
                editor.putString("email", email);
                editor.putString("age", age);
                editor.commit();
                Toast.makeText(MainActivity.this,"Tietojen tallennus",Toast.LENGTH_LONG).show();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, omatTiedot.class);
               startActivity(intent);

            }
        });


    }
} 