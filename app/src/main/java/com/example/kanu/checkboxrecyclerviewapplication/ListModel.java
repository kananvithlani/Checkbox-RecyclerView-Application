package com.example.kanu.checkboxrecyclerviewapplication;

import java.util.HashMap;

public class ListModel {

    boolean isChecked;
    int position;
    int price;

    public ListModel(int position,int price) {
        this.position = position;
        this.price = price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
