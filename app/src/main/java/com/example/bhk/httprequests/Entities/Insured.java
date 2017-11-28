package com.example.bhk.httprequests.Entities;

import java.util.Date;
import java.util.List;

/**
 * Created by Laser on 25/11/2017.
 */

public class Insured {

    private String Cin;
    private String Last_name;
    private String First_name;
    private String login;
    private String password;
    private Date Birth_date;
    private String Phone_number;
    private String E_mail;
    private String driving_licence_id;
    private List<Event> listEvent;

    public String getDriving_licence_id() {
        return driving_licence_id;
    }

    public void setDriving_licence_id(String driving_licence_id) {
        this.driving_licence_id = driving_licence_id;
    }

    public List<Event> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<Event> listEvent) {
        this.listEvent = listEvent;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String cin) {
        Cin = cin;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth_date() {
        return Birth_date;
    }

    public void setBirth_date(Date birth_date) {
        Birth_date = birth_date;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }
}
