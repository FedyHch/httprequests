package com.example.bhk.httprequests.Entities;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by BHK on 22/05/2017.
 */

public class Bank{
    private int id;
    private String name;
    private String logoURL;
    private String serviceUrl;
    private Bitmap logo;
    public Bank() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public Bitmap getLogo() {
        return logo;
    }

    public void setLogo(Bitmap logo) {
        this.logo = logo;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public Bank(int id, String name, String logoURL, String serviceUrl) {

        this.id = id;
        this.name = name;
        this.logoURL = logoURL;
        this.serviceUrl = serviceUrl;
    }

    @Override
    public String toString() {
        return this.id+" "+this.name;
    }
}
