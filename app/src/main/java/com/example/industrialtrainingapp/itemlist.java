package com.example.industrialtrainingapp;

import java.io.Serializable;

public class itemlist implements Serializable {

 String name,roll;
 String phone,mode,organisation,url, sec,proj,tech;

    public itemlist() {
    }

    public itemlist(String name, String roll, String phone, String mode, String organisation, String url, String sec, String proj, String tech) {
        this.name = name;
        this.roll = roll;
        this.phone = phone;
        this.mode = mode;
        this.organisation = organisation;
        this.url = url;
        this.sec = sec;
        this.tech = tech;
        this.proj = proj;
//        this.duration = duration;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getProj() {
        return proj;
    }

    public void setProj(String proj) {
        this.proj = proj;
    }

//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
