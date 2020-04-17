package com.example.andr6buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCalendar(View view)
    {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }
    public void onClicData(View view)
    {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }
}
