package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Studio;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.StudioTable;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Mapper;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.data.tables.Tables.COUNTRY_TABLE;
import static com.mindera.school.music.data.tables.Tables.STUDIO_TABLE;

public class StudioService {
    private StudioTable studioTable;
    private CountryTable countryTable;
    private Mapper mapper;

    public StudioService() {
        this.studioTable = STUDIO_TABLE;
        this.countryTable = COUNTRY_TABLE;
        this.mapper = new Mapper();
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        Studio studio = new Studio();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (studioTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This studio already exits.");
                    return;
                }
                studio.setName(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("City")) {
                studio.setCity(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Country")) {
                studio.setCountryId(mapper.getCountryIdByName(keyValue.getValue().toString()));
            }
        }

        studioTable.add(studio);
    }

    public void removeByName(String name) throws SQLException {
        int id = findIdByName(name);
        if (id == 0) {
            System.out.println("This studio doesn't exists.");
        } else {
            studioTable.removeById(id);
        }
    }

    public int findIdByName(String name) throws SQLException {
        return studioTable.findIdByName(name);
    }

    public Studio find(int id) throws SQLException {
        return studioTable.findById(id);
    }

    public List<Studio> findAll() throws SQLException {
        return studioTable.findAll();
    }

    public void printAllStudios() throws SQLException {
        List<Studio> studioList = findAll();

        if (studioList.isEmpty()) {
            System.out.println("There is no studios.");
            return;
        }

        for (Studio studio : studioList) {
            System.out.println("Studio id: " + studio.getId());
            System.out.println("Name: " + studio.getName() + '\n');
        }
    }

    public void print(int id) throws SQLException {
        Studio studio = find(id);

        if (studio == null) {
            System.out.println("There is no studio.");
            return;
        }

        System.out.println("Studio id: " + studio.getId());
        System.out.println("Name: " + studio.getName());
        System.out.println("Country: " + countryTable.findById(studio.getCountryId()).getName());
        System.out.println("City: " + studio.getCity() + '\n');
    }
}
