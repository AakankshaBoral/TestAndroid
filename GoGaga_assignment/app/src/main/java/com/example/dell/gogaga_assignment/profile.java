package com.example.dell.gogaga_assignment;

/**
 * Created by dell on 01-04-2019.
 */

public class profile {

    String rank;
    int profile_pic;
    String points;
    String name;

    public profile(String rank, int profile_pic, String name, String points) {

        this.rank = rank;
        this.profile_pic = profile_pic;
        this.name = name;
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(int profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
