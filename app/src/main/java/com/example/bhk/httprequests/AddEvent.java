package com.example.bhk.httprequests;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bhk.httprequests.Controller.EventController;
import com.example.bhk.httprequests.Entities.Event;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AddEvent extends AppCompatActivity {


    EditText evTitle, evDescription,evTheme,evPlace;
    Button buttonAddUpdate;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        evTitle = (EditText) findViewById(R.id.eventTitle);
        evDescription = (EditText) findViewById(R.id.eventDescription);
        evTheme = (EditText) findViewById(R.id.eventTheme);
        evPlace = (EditText) findViewById(R.id.eventPlace);
        buttonAddUpdate = (Button) findViewById(R.id.buttonAddEvent);
        datePicker = (DatePicker) findViewById(R.id.datePicker);



        buttonAddUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event e = new Event();
                System.out.println(getDateFromDatePicker(datePicker).toString());
                //e.setEventDate(getDateFromDatePicker(datePicker));
                e.setEventTitle(evTitle.getText().toString());
                e.setEventDescription(evDescription.getText().toString());
                e.setEventTheme(evTheme.getText().toString());
                e.setEventPlace(evPlace.getText().toString());
                EventController.getInstance().createEvent(e);

                Toast.makeText(getApplicationContext(), "Add Successfull", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddEvent.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

    public static Date getDateFromDatePicker(DatePicker d){
        int day = d.getDayOfMonth();
        int month = d.getMonth();
        int year =  d.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }


}
