package com.example.m2test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText user_ed;
    EditText pass_ed;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DB = new DBHelper(this);
        btnlogin = (Button) findViewById(R.id.btnlog);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                user_ed = (EditText) findViewById(R.id.user_id2);
                pass_ed = ( EditText) findViewById(R.id.pass_id2);
            }
        });
    }
}