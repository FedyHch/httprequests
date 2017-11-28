package com.example.bhk.httprequests.Entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Laser on 25/11/2017.
 */

public class Event implements Serializable {

    @SerializedName("eventId")
    private int EventId;
    @SerializedName("eventDate")
    private Date EventDate;
    @SerializedName("eventPlace")
    private String EventPlace;
    @SerializedName("eventTitle")
    private String EventTitle;
    @SerializedName("eventDescription")
    private String EventDescription;
    @SerializedName("eventTheme")
    private String EventTheme;

    public Event() {
    }

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public Date getEventDate() {
        return EventDate;
    }

    public void setEventDate(Date eventDate) {
        EventDate = eventDate;
    }

    public String getEventPlace() {
        return EventPlace;
    }

    public void setEventPlace(String eventPlace) {
        EventPlace = eventPlace;
    }

    public String getEventTitle() {
        return EventTitle;
    }

    public void setEventTitle(String eventTitle) {
        EventTitle = eventTitle;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public String getEventTheme() {
        return EventTheme;
    }

    public void setEventTheme(String eventTheme) {
        EventTheme = eventTheme;
    }

    @Override
    public String toString() {

        return this.getEventTitle()+"  "+this.getEventDescription();
    }
}
