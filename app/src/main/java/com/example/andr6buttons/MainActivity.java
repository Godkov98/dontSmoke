package com.example.andr6buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView thedate;
    private Button buttonCalendar;
    Button buttonData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thedate = (TextView) findViewById(R.id.buttonCalendar);
        
        buttonData = (Button) findViewById(R.id.buttonData);
        buttonData.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonData:
                Intent intent = new Intent(this, ActivityTwo.class)
                        startActivity(intent);
                break;
            default:
                break;
        }
    }

}
