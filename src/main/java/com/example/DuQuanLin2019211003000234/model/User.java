package com.example.DuQuanLin2019211003000234.model;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String eamil;
    private String gender;
    private Date birthDate;

    public User() {
    }

    public User(int id, String username, String password, String eamil, String gender, Date birthDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.eamil = eamil;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", eamil='" + eamil + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
