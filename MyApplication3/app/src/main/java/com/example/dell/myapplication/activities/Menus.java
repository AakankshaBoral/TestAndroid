package com.example.dell.myapplication.activities;

/**
 * Created by dell on 31-07-2018.
 */

public class Menus {



    public int id;
    public String menu;
    public String price;

    public Menus(int id, String menu, String price) {
        this.id = id;
        this.menu = menu;
        this.price = price;
    }

    public  Menus(String menu,String price)
    {
        this.menu = menu;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
