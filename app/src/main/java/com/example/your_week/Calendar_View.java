package com.example.your_week;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Calendar_View extends AppCompatActivity {
    Calendar_View compactCalendar;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar__view);

    }
}