package com.example.bhk.httprequests.Controller;

import com.example.bhk.httprequests.Entities.Event;
import com.example.bhk.httprequests.api.EventApi;

import retrofit.RestAdapter;

/**
 * Created by Laser on 26/11/2017.
 */

public class Adapter {

    RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Constants.SERVER_URL).build();
    EventApi eventApi = adapter.create(EventApi.class);

    private static Adapter instance=null;
    public static Adapter getInstance(){
        if (instance==null){
            instance = new Adapter();
        }return instance;
    }

}
