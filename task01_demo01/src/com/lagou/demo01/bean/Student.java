package com.lagou.demo01.bean;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String sex;
    private Date birthday;
    private String email;
    private String remark;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Student() {
    }

    public Student(String name, String sex, Date birthday, String email, String remark) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.remark = remark;
    }
    public Student(Integer id,String name, String sex, Date birthday, String email, String remark) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
