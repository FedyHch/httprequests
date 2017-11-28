package com.example.bhk.httprequests.api;

import com.example.bhk.httprequests.Entities.Event;

import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Laser on 26/11/2017.
 */

public interface EventApi {

    @GET("/EventRs")
    public void getEvents(Callback<List<Event>> input);

    @POST("/EventRs")
    public void createEvent(@Body Event inEvent, Callback<Response>responseCallback);

    @PUT("/EventRs")
    public void updateEvent(@Body Event inEvent, Callback<Response>responseCallback);

    @DELETE("/EventRs")
    public void deleteEvent(@Body Event inEvent, Callback<Response>responseCallback);

    @DELETE("/EventRs/delete/{idDelete}")
    public void deleteEventById(@Path("idDelete")int id, Callback<Response>responseCallback);
}
