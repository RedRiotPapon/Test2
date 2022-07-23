package com.example.myapplication;

public class UserHelperClass {

    String systolic, diastolic, email, bldgrp, heartrate, date;

    public UserHelperClass() {
    }

    public String getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBldgrp() {
        return bldgrp;
    }

    public void setBldgrp(String bldgrp) {
        this.bldgrp = bldgrp;
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserHelperClass(String systolic, String diastolic, String email, String bldgrp, String heartrate, String date) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.email = email;
        this.bldgrp = bldgrp;
        this.heartrate = heartrate;
        this.date = date;
    }
}