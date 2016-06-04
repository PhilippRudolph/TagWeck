package com.example.tagweck.tagweck;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.*;
import java.util.Calendar;

import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static TextView seconds_text;
    public static TextView minutes_text;
    public static TextView hours_text;

    public static int seconds;
    public static int minutes;
    public static int hours;

    static final String seconds_string = "Sekunden";
    static final String minutes_string = "Minuten";
    static final String hours_string = "Stunden";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seconds_text = (TextView)findViewById(R.id.seconds_text);
        minutes_text = (TextView)findViewById(R.id.minutes_text);
        hours_text = (TextView)findViewById(R.id.hours_text);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt(seconds_string);
            minutes = savedInstanceState.getInt(minutes_string);
            hours = savedInstanceState.getInt(hours_string);
            seconds_text.setText(Integer.toString(seconds));
            minutes_text.setText(Integer.toString(minutes));
            hours_text.setText(Integer.toString(hours));
        }
        else {
            SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);

        //    if (prefs.contains("initialisiert")) {
                seconds_text.setText(Integer.toString(prefs.getInt(seconds_string, getseconds())));
                minutes_text.setText(Integer.toString(prefs.getInt(minutes_string, getminutes())));
                hours_text.setText(Integer.toString(prefs.getInt(hours_string, gethours())));
        //    }
        //    else {
        //        seconds_text.setText(Integer.toString(getseconds()));
        //        minutes_text.setText(Integer.toString(getminutes()));
        //        hours_text.setText(Integer.toString(gethours()));
        //    }
        }

        //seconds.setText(Integer.toString(getseconds()));
        //minutes.setText(Integer.toString(getminutes()));
        //hours.setText(Integer.toString(gethours()));
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(seconds_string, seconds);
        savedInstanceState.putInt(minutes_string, minutes);
        savedInstanceState.putInt(hours_string, hours);
    }

    public void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(seconds_string, seconds);
        editor.putInt(minutes_string, minutes);
        editor.putInt(hours_string, hours);
        editor.putBoolean("initialisiert", true);
        editor.commit();
    }

    private int getseconds() {
        Calendar c = Calendar.getInstance();
        int sec = c.get(Calendar.SECOND);
        seconds = sec;
        return sec;
    }
    private int getminutes() {
        Calendar c = Calendar.getInstance();
        int min = c.get(Calendar.MINUTE);
        minutes = min;
        return min;
    }
    private int gethours() {
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR_OF_DAY);
        hours = h;
        return h;
    }
    public void refresh(View view) {
        seconds_text.setText(Integer.toString(getseconds()));
        minutes_text.setText(Integer.toString(getminutes()));
        hours_text.setText(Integer.toString(gethours()));
    }
}
