package com.example.industrialtrainingapp;

public class completelist {

    String n,r,phoneno;

    public completelist() {

    }
    public completelist(String n, String r, String phoneno) {
        this.n = n;
        this.r = r;
        this.phoneno = phoneno;
    }

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public String getRoll() {
        return r;
    }

    public void setRoll(String r) {
        this.r = r;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
