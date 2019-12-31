package com.mindera.school.music.data.rows;

import com.mindera.school.music.ui.StringCode;

public class User {
    private int id;
    private String name;
    private String birthdate;
    private char gender;
    private int countryId;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, String name, String birthdate, char gender, int countryId, String email, String password) {
        this.id = id;
        this.name = StringCode.capitalizeEachWord(name);
        this.birthdate = birthdate;
        this.gender = gender;
        this.countryId = countryId;
        this.email = email;
        this.password = password;
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
        this.name = StringCode.capitalizeEachWord(name);
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
