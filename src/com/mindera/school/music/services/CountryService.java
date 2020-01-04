package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Country;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.ui.KeyValue;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.data.tables.Tables.COUNTRY_TABLE;

public class CountryService {
    private CountryTable countryTable;

    public CountryService() {
        this.countryTable = COUNTRY_TABLE;
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        Country country = new Country();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (countryTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This country already exits.");
                    return;
                }
                country.setName(keyValue.getValue().toString());
            }
        }

        countryTable.add(country);
    }

    public void removeByName(String name) throws SQLException {
        int id = findIdByName(name);
        if (id == 0) {
            System.out.println("This country doesn't exists.");
        } else {
            countryTable.removeById(id);
        }
    }

    public int findIdByName(String name) throws SQLException {
        return countryTable.findIdByName(name);
    }

    public Country find(int id) throws SQLException {
        return countryTable.findById(id);
    }

    public List<Country> findAll() throws SQLException {
        return countryTable.findAll();
    }

    public void printAll() throws SQLException {
        List<Country> countryList = findAll();

        if (countryList.isEmpty()) {
            System.out.println("There is no countrys.");
            return;
        }

        for (Country country : countryList) {
            System.out.println("Country id: " + country.getId());
            System.out.println("Name: " + country.getName() + '\n');
        }
    }

    public void print(int id) throws SQLException {
        Country country = find(id);

        if (country == null) {
            System.out.println("There is no country.");
            return;
        }

        System.out.println("Country id: " + country.getId());
        System.out.println("Name: " + country.getName() + '\n');
    }
}
