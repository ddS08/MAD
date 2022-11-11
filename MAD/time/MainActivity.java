package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onc(View v)
    {
        tp = (TimePicker) findViewById(R.id.timep);
        int min,hrs;
        min = tp.getCurrentMinute();
        hrs=tp.getCurrentHour();
        if (min<10) {
            Toast.makeText(this, hrs + ":0" + min, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, hrs + ":" + min, Toast.LENGTH_SHORT).show();
        }

    }

}
