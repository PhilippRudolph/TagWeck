package com.example.tagweck.tagweck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.*;
import java.util.Calendar;

import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView seconds;
    private TextView minutes;
    private TextView hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seconds = (TextView)findViewById(R.id.seconds);
        minutes = (TextView)findViewById(R.id.minutes);
        hours = (TextView)findViewById(R.id.hours);

        seconds.setText(Integer.toString(getseconds()));
        minutes.setText(Integer.toString(getminutes()));
        hours.setText(Integer.toString(gethours()));
    }

    private int getseconds() {
        Calendar c = Calendar.getInstance();
        int seconds;
        return seconds = c.get(Calendar.SECOND);
    }
    private int getminutes() {
        Calendar c = Calendar.getInstance();
        int minutes;
        return minutes = c.get(Calendar.MINUTE);
    }
    private int gethours() {
        Calendar c = Calendar.getInstance();
        int hours;
        return hours = c.get(Calendar.HOUR_OF_DAY);
    }
    public void refresh(View view) {
        seconds.setText(Integer.toString(getseconds()));
        minutes.setText(Integer.toString(getminutes()));
        hours.setText(Integer.toString(gethours()));
    }
}
