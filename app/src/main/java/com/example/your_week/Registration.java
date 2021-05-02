package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    //Esitellään luokassa käytettävät muuttujia. Näihin tallennetaan widgettejä myöhemmin.
    EditText ptName, ptAge, ptEmail;
    Button btSave;

    //Esitellään sharedPrefences -nimet valmiiksi, joten niitä ei tarvitse toistaa uudelleen.
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


        // tietojen tallennus nappia painaessa
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Luodaan myEdit niminen sharedpreferences muuttuja.
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                //Luodaan intent valmiiksi. Tällä siirrytään tältä aktiviteetilta userinfo-aktiviteettiin.
                Intent intent = new Intent(Registration.this, UserInfo.class);

                //Haetaan täytetyistä kentistä tiedot ja tallennetaan ne muuttujiin
                String name = ptName.getText().toString();
                String age = ptAge.getText().toString();
                String email = ptEmail.getText().toString();

                //Jos jokin ruutu on tyhjä, annetaan tästä toast, sekä ilmoitus ruudussa.
                if (TextUtils.isEmpty(name)) {
                    ptName.setError("Lisää nimi");
                    Toast.makeText(getApplicationContext(), "Lisää nimi", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(age)) {
                    ptAge.setError("Lisää ikä");
                    Toast.makeText(getApplicationContext(), "Lisää ikä", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email)) {
                    ptEmail.setError("Lisää sähköposti");
                    Toast.makeText(getApplicationContext(), "Lisää sähköposti", Toast.LENGTH_SHORT).show();
                } else if (ptEmail != null || ptName != null || ptAge != null) {
                    //Ainoastaan, jos kaikki kentätä on täytetty tallennetaan tiedot ja siirrytään omat tiedot -aktiviteettiin.
                    myEdit.putString(KEY_NAME, ptName.getText().toString());
                    myEdit.putString(KEY_AGE, ptAge.getText().toString());
                    myEdit.putString(KEY_EMAIL, ptEmail.getText().toString());
                    myEdit.apply();
                    startActivity(intent);

                }

            }
        });
    }

}
