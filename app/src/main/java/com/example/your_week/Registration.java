package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registration);
}
    public void SendValues(View view) {
        //käyttäjän tietojen pyytäminen ja niiden tallennus sharedpreferences tietokantaan

        SharedPreferences sharedPreferences = getSharedPreferences("UserData",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        Intent intent = new Intent(this, TIEDOT.class);

        EditText editName = (EditText) findViewById(R.id.ptName);
        EditText editAge = (EditText) findViewById(R.id.ptAge);
        EditText editEmail = (EditText) findViewById(R.id.ptEmail);

        myEdit.putString("name", editName .getText().toString());
        myEdit.putString("age", editAge.getText().toString());
        myEdit.putString("email", editEmail.getText().toString());

        String user_name = editName .getText().toString();
        String user_age = editAge.getText().toString();
        String user_email = editEmail.getText().toString();

        if(TextUtils.isEmpty(user_name)) {
            editName.setError("Ei nimeä");
            Toast.makeText(Registration.this,"Lisää vielä nimi", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(user_age)) {
            editAge.setError("Ei ikää");
            Toast.makeText(Registration.this,"Lisää vielä ikä", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(user_email)) {
            editEmail.setError("Ei sähköpostia");
            Toast.makeText(Registration.this,"Lisää vielä sähköpostiosoite", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Registration.this, "Tiedot tallennettu!", Toast.LENGTH_LONG).show();
        }

        myEdit.apply();
        startActivity(intent);

    }
}
