package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Country;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.ui.KeyValue;

import java.util.List;

import static com.mindera.school.music.data.tables.Tables.*;

public class CountryService {
    CountryTable countryTable;

    public CountryService() {
        this.countryTable = COUNTRY_TABLE;
    }

    public void add(List<KeyValue> keyValueList) {
        Country country = new Country();

        country.setId(countryTable.getNewId());

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if(countryTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This country already exits.");
                    return;
                }
                country.setName(keyValue.getValue().toString());
            }
        }

        countryTable.add(country);
    }

    public void removeCountry(int id) {
        countryTable.remove(id);
    }

    public Country findCountry(int id) {
        return countryTable.findById(id);
    }

    public List<Country> findAllCountrys() {
        return countryTable.findAll();
    }

    public void printAllCountrys() {
        List<Country> countryList = findAllCountrys();

        if(countryList.isEmpty()) {
            System.out.println("There is no country.");
            return;
        }

        for (Country country : countryList) {
            System.out.println("Country id: " + country.getId());
            System.out.println("Name: " + country.getName() + '\n');
        }
    }

    public void printCountry(int id) {
        Country country = findCountry(id);
        if(country == null) {
            System.out.println("There is no country with this id.");
            return;
        }

        System.out.println("Country id: " + country.getId());
        System.out.println("Name: " + country.getName() + '\n');
    }
}
