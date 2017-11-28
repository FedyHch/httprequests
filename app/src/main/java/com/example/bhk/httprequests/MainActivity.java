package com.example.bhk.httprequests;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhk.httprequests.AdaptersAndHandlers.HttpHandler;
import com.example.bhk.httprequests.Controller.EventController;
import com.example.bhk.httprequests.Entities.Bank;
import com.example.bhk.httprequests.Entities.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {
    private String TAG = "JsonBanksTag";
    private TextView tvJson;
    private Button parseButton;
    public static ArrayList<Event> EventList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvJson = (TextView) findViewById(R.id.json);
        parseButton = (Button) findViewById(R.id.toListButton);
        parseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        try {
            new GetBanks().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Event e = new Event();
//        e.setEventTitle("xxpo");
//        e.setEventTheme("xxpo");
//        EventController.getInstance().createEvent(e);

//        e.setEventId(7);
//        e.setEventTitle("TestUpdateAndroid");
//        EventController.getInstance().updateEvent(e);
//        e.setEventId(10);
//        e.setEventTitle("titreLayout");
//        EventController.getInstance().deleteEvent(e);

    }


    private class GetBanks extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           //Any code that must be executed before making the hhtp request service call must be declared here
            EventList = new ArrayList<>();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Bitmap bmp=null;
            HttpHandler sh = new HttpHandler();
            String url = "http://10.0.2.2:18080/cga-web/rest/EventRs";
            // Making a request to url and getting response

            String jsonStr = sh.readContents(url);
            //Parsing json to entities
            if (jsonStr != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    refreshTextView(jsonStr);
                   // JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray banks = jsonArray;

                    // looping through All nodes(banks)
                    for (int i = 0; i < banks.length(); i++) {
                        JSONObject c = banks.getJSONObject(i);
                        Event event = new Event();

                      //  URL urlImage = null;
                       // try {
                        //    urlImage = new URL(c.getString("logo"));
                        //     bmp = BitmapFactory.decodeStream(urlImage.openConnection().getInputStream());
                        //  } catch (MalformedURLException e) {
                        //     e.printStackTrace();
                        //  } catch (IOException e) {
                        //     e.printStackTrace();
                        // }

                        // Setting bank details
                        event.setEventPlace(c.getString("eventPlace"));
                        event.setEventTitle(c.getString("eventTitle"));
                        event.setEventDescription(c.getString("eventDescription"));
                        event.setEventTheme(c.getString("eventTheme"));
                        event.setEventId(c.getInt("eventId"));
                        //Adding bank to the list
                        EventList.add(event);

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //This code is executed just after the doInBackground finishes executing
            Log.d("Event list",EventList.toString());

        }
    }
    public void refreshTextView(String s){

        tvJson.setText("cga Event Management");
    }


}
