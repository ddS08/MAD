package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String l1[]={"Buy an item","Profile","Sell an item","L"};


        // super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListAdapter ls = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,l1);
        ListView lv = (ListView) findViewById(R.id.list1);
        lv.setAdapter(ls);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String l1 = String.valueOf(parent.getItemAtPosition(position));
                if(l1.equals("Buy an item"))
                {
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);

                    startActivity(i);
                }
                else if(l1.equals("Profile"))
                {
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);

                    startActivity(i);
                }
                else if(l1.equals("Sell an item"))
                {
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);

                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);

                    startActivity(i);
                }
            }
        });
    }
}