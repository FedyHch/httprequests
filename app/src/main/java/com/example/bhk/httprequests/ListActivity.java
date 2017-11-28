package com.example.bhk.httprequests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bhk.httprequests.Entities.Bank;
import com.example.bhk.httprequests.Entities.Event;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
ListView lvBanks;
    private Button addButton;
    //public static Event event = new Event();
    private Event event = new Event();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        addButton= (Button) findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, AddEvent.class);
                startActivity(intent);
            }
        });

        ArrayList<Event> EventList =  MainActivity.EventList;
        ArrayAdapter arrayAdapter;
        arrayAdapter = new ArrayAdapter(this,R.layout.item, R.id.tvName, EventList);
        lvBanks= (ListView) findViewById(R.id.banksListView);
        lvBanks.setAdapter(arrayAdapter);

        lvBanks.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = lvBanks.getItemAtPosition(position);
                Event e = (Event)o; //As you are using Default String Adapter
                System.out.println("**************************"+ e);
                event=e;
                System.out.println(event.getEventId()+" from listActivity");
                Intent intent = new Intent(ListActivity.this, UpdateActivity.class);
                intent.putExtra("EventFromList",event);
                startActivity(intent);
            }
        });

    }
}
