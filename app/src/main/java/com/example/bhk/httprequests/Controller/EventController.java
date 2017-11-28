package com.example.bhk.httprequests.Controller;

import com.example.bhk.httprequests.Entities.Event;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Laser on 26/11/2017.
 */

public class EventController {

    private static EventController instance=null;
    public static EventController getInstance(){
        if (instance==null){
            instance = new EventController();
        }return instance;
    }
    public void createEvent (Event e){
        Adapter.getInstance().eventApi.createEvent(e, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                System.out.println("success");
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("failure");
            }
        });

    }

    public void updateEvent(Event e){
        Adapter.getInstance().eventApi.updateEvent(e, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                System.out.println("success update");
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("failure update");
            }
        });
    }

    public void deleteEvent(Event e){
        Adapter.getInstance().eventApi.deleteEvent(e, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                System.out.println("success delete");
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("failure delete");
            }
        });
    }

    public void deleteEventById(int id){
        Adapter.getInstance().eventApi.deleteEventById(id, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                System.out.println("delete Ok from Controller");
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("delete Not Ok from Controller");

            }
        });
    }
}


