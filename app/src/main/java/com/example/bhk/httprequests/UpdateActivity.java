package com.example.bhk.httprequests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bhk.httprequests.Controller.EventController;
import com.example.bhk.httprequests.Entities.Event;

public class UpdateActivity extends AppCompatActivity {

    EditText evTitleUpdate, evDescriptionUpdate,evThemeUpdate,evPlaceUpdate;
    Button buttonUpdateEvent,buttonDeleteEvent;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        event = (Event) getIntent().getSerializableExtra("EventFromList");
        evTitleUpdate = (EditText) findViewById(R.id.eventTitleUpdate);
        evDescriptionUpdate = (EditText) findViewById(R.id.eventDescriptionUpdate);
        evThemeUpdate =(EditText) findViewById(R.id.eventThemeUpdate);
        evPlaceUpdate =(EditText) findViewById(R.id.eventPlaceUpdate);
        buttonUpdateEvent=(Button) findViewById(R.id.buttonUpdateEvent);
        buttonDeleteEvent=(Button) findViewById(R.id.buttonDeleteEvent);
        if(event.getEventTitle()!=null) {
            evTitleUpdate.setText(event.getEventTitle());
        }
        if(event.getEventTheme()!=null) {
            evThemeUpdate.setText(event.getEventTheme());
        }
            if(event.getEventDescription()!=null) {
                evDescriptionUpdate.setText(event.getEventDescription());
            }
                if(event.getEventPlace()!=null) {
                    evPlaceUpdate.setText(event.getEventPlace());
                }

        buttonUpdateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                event.setEventTitle(evTitleUpdate.getText().toString());
                event.setEventDescription(evDescriptionUpdate.getText().toString());
                event.setEventTheme(evThemeUpdate.getText().toString());
                event.setEventPlace(evPlaceUpdate.getText().toString());
                EventController.getInstance().updateEvent(event);
                System.out.println(event.getEventId()+"  "+event.getEventDescription()+"  "+event.getEventTitle()+"  "+event.getEventTheme()+"  "+event.getEventPlace());
                Toast.makeText(getApplicationContext(), "Update Successfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonDeleteEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventController.getInstance().deleteEventById(event.getEventId());
                System.out.println("fromUpdateActivity delete");
                Toast.makeText(getApplicationContext(), "Delete Successfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
