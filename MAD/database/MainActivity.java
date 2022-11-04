package com.example.experiment10;

import androidx.appcompat.app.*;
import android.database.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    //initialize variables
    /* EditText name, contact, address, course;*/
    EditText name, contact;
    Button insert, update, delete, view, val;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditTexts UI
        name = findViewById(R.id.editTextTextPersonName3);
        contact = findViewById(R.id.editTextTextPersonName4);
       /* address = findViewById(R.id.editTextTextPersonName5);
        course = findViewById(R.id.editTextTextPersonName);*/

        //Buttons UI
        insert = findViewById(R.id.button);
        update = findViewById(R.id.button2);
        delete = findViewById(R.id.button3);
        view = findViewById(R.id.button4);
        val = findViewById(R.id.button5);
        //initialize Database
        DB = new DBHelper(this);


    }

    public void insert_Data(View v) {
        String nameTXT = name.getText().toString();
        String contactTXT = contact.getText().toString();
        /*String courseTXT = course.getText().toString();
        String addressTXT = address.getText().toString();*/

        Boolean checkInsertData = DB.insertuserdata(nameTXT, contactTXT);
        if (checkInsertData)
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

        DB.close();
    }


    public void update_Data(View v){
        String nameTXT = name.getText().toString();
        String contactTXT = contact.getText().toString();
      /*  String addressTXT = address.getText().toString();
        String courseTXT = course.getText().toString();*/

        Boolean checkUpdateData = DB.updateuserdata(nameTXT, contactTXT);
        if(checkUpdateData)
            Toast.makeText(MainActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();

        DB.close();
    }

    public void delete_Data(View v){
        String nameTXT = name.getText().toString();
        Boolean checkDeleteData = DB.deletedata(nameTXT);
        if(checkDeleteData)
            Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();

        DB.close();
    }

    public void view_Data(View v){

        Cursor res = DB.getdata();
        if(res.getCount()==0){
            Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){

            buffer.append("Name: "+res.getString(0)+"\n");
            buffer.append("Contact: "+res.getString(1)+"\n");
            /*buffer.append("Course: "+res.getString(3)+"\n");
            buffer.append("Year: "+res.getString(2)+"\n\n");*/
        }

        //alert pop-up for viewing all data
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("User Entries");
        builder.setMessage(buffer.toString());
        builder.show();

        DB.close();
    }
    public void validate(View v)
    {
        String nameTXT = name.getText().toString();
        String contactTXT = contact.getText().toString();
        Boolean validation = DB.validation(nameTXT, contactTXT);
        if(validation)
            Toast.makeText(MainActivity.this, "Entry validated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Entry Not validated", Toast.LENGTH_SHORT).show();
        DB.close();
    }

}
