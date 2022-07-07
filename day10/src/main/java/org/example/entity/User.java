package org.example.entity;

import javax.naming.Name;

public class User {
    private String Name;
    private String password;
    private String sex;
    private int age;

    public User() {
    }

    public User(String name, String password, String sex, int age) {
        Name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
