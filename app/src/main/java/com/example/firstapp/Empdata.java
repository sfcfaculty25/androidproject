package com.example.firstapp;

public class Empdata
{
    public String empid;
    public String fname;
    public String lname;
    public String contact;
    public String username;
    public String password;

    public Empdata()
    {
    }
    //to make constructor, press ALT+INSERT
    public Empdata(String empid, String fname, String lname, String contact, String username, String password) {
        this.empid = empid;
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
        this.username = username;
        this.password = password;
    }

    public String getEmpid() {
        return empid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getContact() {
        return contact;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
