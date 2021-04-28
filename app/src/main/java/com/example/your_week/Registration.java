package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    EditText ptName, ptAge, ptEmail;
    Button btSave;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "userData";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //alustus
        ptName = findViewById(R.id.ptName);
        ptAge = findViewById(R.id.ptAge);
        ptEmail = findViewById(R.id.ptEmail);
        btSave = findViewById(R.id.btSave);
        // shared prefs esittely
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);

        // tietojen tallennus nappia painaessa
        btSave.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          SharedPreferences.Editor myEdit = sharedPreferences.edit();
                                          myEdit.putString(KEY_NAME, ptName.getText().toString());
                                          myEdit.putString(KEY_AGE, ptAge.getText().toString());
                                          myEdit.putString(KEY_EMAIL, ptEmail.getText().toString());
                                          myEdit.apply();
                                          Intent intent = new Intent(Registration.this, UserInfo.class);

                                          startActivity(intent);

                                      }

                                  }
        );
    }

}
