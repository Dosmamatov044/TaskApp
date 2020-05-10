package com.example.taskapp.models;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String desc;
    private  String How_are_you;


    public Task(String title, String desc, String how_are_you) {
        this.title = title;
        this.desc = desc;
       this.How_are_you = how_are_you;
    }

    public String getHow_are_you() {

        return How_are_you;
    }

    public void setHow_are_you(String how_are_you) {
        How_are_you = how_are_you;
    }

    public Task() {
    }

    public String getTitle() {
        return title;
    }
    public String getDesc() {
        return desc;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
