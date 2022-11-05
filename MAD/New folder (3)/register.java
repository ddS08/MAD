package com.example.m2test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText name_ed,user_ed,email_ed,pass_ed,repass_ed,phone_ed;
    Button btnregister;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name_ed = (EditText) findViewById(R.id.name_id);
        user_ed = (EditText) findViewById(R.id.user_id);
        email_ed = (EditText) findViewById(R.id.email_id);
        pass_ed = (EditText) findViewById(R.id.pass_id);
        repass_ed = (EditText) findViewById(R.id.repass_id);
        phone_ed = (EditText) findViewById(R.id.phone_id);
        btnregister = (Button) findViewById(R.id.btnregister);
        DB = new DBHelper(this);
    }

    public void insert_Data(View v) {
        String nameTXT = name_ed.getText().toString();
        if(nameTXT.length()>5)
        {
            Toast.makeText(register.this, "length of name must be less than or equal to 5 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!nameTXT.matches("^[a-zA-Z]*$"))
        {
            Toast.makeText(register.this, "Name should have only alphabets", Toast.LENGTH_SHORT).show();
            return;
        }
        String useridTXT =pass_ed.getText().toString();

        String passTXT = user_ed.getText().toString();
        String emailTXT = email_ed.getText().toString();
        if(!emailTXT.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))
        {
            Toast.makeText(register.this, "Invalid email", Toast.LENGTH_SHORT).show();
            return;
        }
        String contactTXT = phone_ed.getText().toString();
        /*String courseTXT = course.getText().toString();
        String addressTXT = address.getText().toString();*/
        String pass1= pass_ed.getText().toString();
        String pass2=repass_ed.getText().toString();
        if(!pass1.equals(pass2))
        {
            Toast.makeText(register.this, "passwords dont match", Toast.LENGTH_SHORT).show();
            return;
        }
        Boolean checkInsertData = DB.insertuserdata(nameTXT,useridTXT,passTXT,emailTXT,contactTXT);
        if (checkInsertData)
        {
            Toast.makeText(register.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(register.this,login.class);
            startActivity(i);
        }

        else
            Toast.makeText(register.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

        DB.close();
    }
}