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

    public static final String EXTRA_TEXT = "name";
    public static final String EXTRA_TEXT1 = "age";
    public static final String EXTRA_TEXT2 = "email";

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registration);
}
    public void SendValues(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("UserData",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        EditText editText = (EditText) findViewById(R.id.ptName);
        EditText editText1 = (EditText) findViewById(R.id.ptAge);
        EditText editText2 = (EditText) findViewById(R.id.ptEmail);

        myEdit.putString("name", editText.getText().toString());
        myEdit.putString("age", editText1.getText().toString());
        myEdit.putString("email", editText2.getText().toString());

        String user_name = editText.getText().toString();
        String user_age = editText1.getText().toString();
        String user_email = editText2.getText().toString();

        if(TextUtils.isEmpty(user_name)) {
            Toast.makeText(Registration.this, "Täytä puuttuvat tiedot", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(user_age)) {
            Toast.makeText(Registration.this, "Täytä puuttuvat tiedot", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(user_email)) {
            Toast.makeText(Registration.this, "Täytä puuttuvat tiedot", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(this, TIEDOT.class);

        intent.putExtra(EXTRA_TEXT, user_name);
        intent.putExtra(EXTRA_TEXT1, user_age);
        intent.putExtra(EXTRA_TEXT2, user_email);

        myEdit.commit();
        Toast.makeText(Registration.this, "Tiedot tallennettu!", Toast.LENGTH_LONG).show();

        startActivity(intent);
    }
}
