package com.example.andr6buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CalendarActivity extends AppCompatActivity {
    SharedPreferences settings;
    SharedPreferences settings2;
    final static String PREFS_FILE = "Storage";
    final static String StorageObj = "StorageObj";
    Storage storage;
    final static String PREFS_FILE2 = "price_settings";
    final static String PRICE_VALUE = "price_value";
    private CalendarView mCalendarView;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_layout);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        settings2 = getSharedPreferences(PREFS_FILE2, MODE_PRIVATE);
        Gson gson = new Gson();
        float onePrice = settings2.getFloat(PRICE_VALUE, 0)/20;
        String json = settings.getString(StorageObj,"");
        if (json.equals(""))
        {
            storage = new Storage();
        }
        else
        {
            storage = gson.fromJson(json, Storage.class);
        }
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        TextView smoked = (TextView)findViewById(R.id.edWasted);
        smoked.setText("Сегодня выкурено: " + String.valueOf(storage.GetToDateCount(format.format(dateNow))));
        TextView wasted = (TextView)findViewById(R.id.edWasted);
        wasted.setText("Сегодня потрачено: " + String.valueOf(storage.GetToDateCount(format.format(dateNow))*onePrice));
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                String Year = String.valueOf(year);
                String Month = String.valueOf(month+1);
                String Day = String.valueOf(dayOfMonth);
                if (Month.length() == 1)
                {
                    Month = "0" + Month;
                }
                if (Day.length() == 1)
                {
                    Day = "0" + Day;
                }
                String date = Day + "." + Month + "." + Year;
                TextView smoked = (TextView)findViewById(R.id.edWasted);
                smoked.setText(date + " выкурено: " + String.valueOf(storage.GetToDateCount(date)));
                settings2 = getSharedPreferences(PREFS_FILE2, MODE_PRIVATE);
                float onePrice = settings2.getFloat(PRICE_VALUE, 0)/20;
                TextView wasted = (TextView)findViewById(R.id.edWasted);
                wasted.setText(date + " потрачено: " + String.valueOf(storage.GetToDateCount(date)*onePrice));
            }
        });
    }
}