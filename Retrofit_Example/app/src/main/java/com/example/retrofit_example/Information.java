package com.example.retrofit_example;

public class Information {

    String userid;
    String id;
    String title;
    String body;

    public Information(String userid,String id,String title,String body) {

        this.userid = userid;
        this.id = id;
        this.title = title;
        this.body = body;


    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
