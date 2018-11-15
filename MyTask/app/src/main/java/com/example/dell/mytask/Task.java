package com.example.dell.mytask;

/**
 * Created by dell on 15-11-2018.
 */

public class Task {

    public  String taskname;
    public String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;

    public Task(String taskname, String date, String time) {

        this.taskname = taskname;
        this.date = date;
        this.time = time;
    }

    public Task(int id,String taskname, String date, String time) {

        this.id = id;
        this.taskname = taskname;
        this.date = date;
        this.time = time;
    }



    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String time;
}
