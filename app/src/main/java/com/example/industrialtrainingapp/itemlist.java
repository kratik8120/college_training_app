package com.example.industrialtrainingapp;

import java.io.Serializable;

public class itemlist implements Serializable {

 String name,roll;

 String mode,organisation,url, sec,project,technology;

    public itemlist() {
    }

    public itemlist(String name, String roll, String mode, String organisation, String url, String sec, String project, String technology) {
        this.name = name;
        this.roll = roll;
        this.mode = mode;
        this.organisation = organisation;
        this.url = url;
        this.sec = sec;
        this.technology = technology;
        this.project = project;

    }
    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
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

    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
}
