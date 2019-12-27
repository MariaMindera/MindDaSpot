package com.mindera.school.music.data.rows;

import com.mindera.school.music.data.Row;

public class Studio implements Row {
    private int id;
    private String name;
    private String city;
    private int countryId;

    public Studio() {
    }

    public Studio(int id, String name, String city, int countryId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.countryId = countryId;
    }

    @Override
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
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
