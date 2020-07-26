package com.lagou.demo01.bean;

import java.util.Date;

public class Classes {
    private int id;
    private String name;
    private String grand;
    private String headmaster;
    private String seat;
    private String slogan;

    public Classes() {
    }

    public Classes(int id, String name, String grand, String headmaster, String seat, String slogan) {
        this.id = id;
        this.name = name;
        this.grand = grand;
        this.headmaster = headmaster;
        this.seat = seat;
        this.slogan = slogan;
    }

    public Classes(String name, String grand, String headmaster, String seat, String slogan) {
        this.name = name;
        this.grand = grand;
        this.headmaster = headmaster;
        this.seat = seat;
        this.slogan = slogan;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grand='" + grand + '\'' +
                ", headmaster='" + headmaster + '\'' +
                ", seat='" + seat + '\'' +
                ", slogan='" + slogan + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrand() {
        return grand;
    }

    public void setGrand(String grand) {
        this.grand = grand;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
