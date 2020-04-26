package com.example.andr6buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class Statistic extends AppCompatActivity {

    SharedPreferences settings;
    SharedPreferences settings2;
    final static String PREFS_FILE = "Storage";
    final static String StorageObj = "StorageObj";
    Storage storage;
    final static String PREFS_FILE2 = "price_settings";
    final static String PRICE_VALUE = "price_value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        settings2 = getSharedPreferences(PREFS_FILE2, MODE_PRIVATE);
        Gson gson = new Gson();
        float onePrice = settings2.getFloat(PRICE_VALUE, 0)/20;
        String json = settings.getString(StorageObj,"");
        if (json.equals(""))
        {
            storage = new Storage();
        }
        else {
            storage = gson.fromJson(json, Storage.class);
        }
        TextView wasted = (TextView)findViewById(R.id.edSmoked);
        TextView smoked = (TextView)findViewById(R.id.edWasted);
        wasted.setText("За все время потрачено: " + String.valueOf(storage.getAllCount()*onePrice));
        smoked.setText("За все время выкурено: "+ String.valueOf(storage.getAllCount()));
    }
}
