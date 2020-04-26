package com.example.andr6buttons;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Storage
{
    private ArrayList<DateAndCount> dates = new ArrayList<DateAndCount>();
    public void Add(String date, int count)
    {
        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.get(i).toString().equals(date))
            {
                DateAndCount dac = dates.get(i);
                dates.set(i, new DateAndCount(date, dac.Count+1));
                return;
            }
        }
        dates.add(new DateAndCount(date, count));
    }
    public int GetToDateCount(String date)
    {
        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.get(i).toString().equals(date))
            {
                DateAndCount dac = dates.get(i);
                return dac.Count;
            }
        }
        return 0;
    }
    public int getAllCount(String Date)
    {
        int count = 0;
        for (int i = 0; i < dates.size(); i++)
        {
            DateAndCount dac = dates.get(i);
            count += dac.Count;
        }
        return  count;
    }
}

class DateAndCount
{
    private String Date;
    public int Count;

    public DateAndCount(String date, int count)
    {
        Date = date;
        Count = count;
    }

    @NonNull
    @Override
    public String toString() {
        return Date;
    }
}
