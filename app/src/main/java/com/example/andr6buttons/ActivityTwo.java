package com.example.andr6buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class ActivityTwo extends AppCompatActivity {

    SharedPreferences settings;
    final static String PREFS_FILE = "price_settings";
    final static String PRICE_VALUE = "price_value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText(Float.toString(settings.getFloat(PRICE_VALUE, 0)));
    }
    public void savePrice(View view)
    {
        EditText editText = (EditText)findViewById(R.id.editText);
        String price = editText.getText().toString();
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putFloat(PRICE_VALUE, Float.parseFloat(price));
        prefEditor.apply();
        Intent intent = (new Intent(ActivityTwo.this, MainActivity.class));
        startActivity(intent);
    }
}
