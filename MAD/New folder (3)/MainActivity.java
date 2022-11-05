package com.example.m2test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DBHelper DBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper = new DBHelper(this);
    }
    public void Register(View v)
    {
        Intent i = new Intent(MainActivity.this,register.class);
        startActivity(i);
    }
    public void login(View v)
    {
        Intent i = new Intent(MainActivity.this,login.class);
        startActivity(i);
    }
}