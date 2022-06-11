package com.example.firstapp;

public class Std
{
    //properties
    public String stdid;
    public String stdname;
    public String course;
    public String img;

    //empty constructor
    public Std()
    {
    }

    public Std(String stdid, String stdname, String course, String img)
    {
        this.stdid = stdid;
        this.stdname = stdname;
        this.course = course;
        this.img = img;
    }

    public String getStdid() {
        return stdid;
    }

    public String getStdname() {
        return stdname;
    }

    public String getCourse() {
        return course;
    }

    public String getImg() {
        return img;
    }
}




