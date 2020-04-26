package com.example.andr6buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    SharedPreferences settings;
    final static String PREFS_FILE = "Storage";
    final static String StorageObj = "StorageObj";
    Storage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = settings.getString(StorageObj,"");
        if (json.equals(""))
        {
            storage = new Storage();
        }
        else
        {
            storage = gson.fromJson(json, Storage.class);
        }
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
    public void onClick_SmokeBreak(View view)
    {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        storage.Add(format.format(dateNow), 1);
        Toast toast = Toast.makeText(this,  "+1 сигарета." + " Сегодня уже " + storage.GetToDateCount(format.format(dateNow)), Toast.LENGTH_SHORT);
        toast.show();

        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(storage);
        editor.putString(StorageObj, json);
        editor.commit();
    }
    public void onClick_Statistic(View view)
    {
        Intent intent = new Intent(this, Statistic.class);
        startActivity(intent);
    }
}
