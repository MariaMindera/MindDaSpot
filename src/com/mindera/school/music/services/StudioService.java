package com.mindera.school.music.services;

import com.mindera.school.music.Mapper;
import com.mindera.school.music.data.rows.Studio;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.StudioTable;
import com.mindera.school.music.ui.KeyValue;

import static com.mindera.school.music.data.tables.Tables.*;

import java.util.List;

public class StudioService {
    StudioTable studioTable;
    CountryTable countryTable;
    Mapper mapper;

    public StudioService() {
        this.studioTable = STUDIO_TABLE;
        this.countryTable = COUNTRY_TABLE;
        this.mapper = new Mapper();
    }

    public void add(List<KeyValue> keyValueList) {
        Studio studio = new Studio();

        studio.setId(studioTable.getNewId());

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (studioTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This Studio already exits.");
                    return;
                }
                studio.setName(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("City")) {
                studio.setCity(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Country")) {
                mapper.getCountryIdByName(keyValue.getValue().toString());
            }
        }

        studioTable.add(studio);
    }

    public void removeStudio(int id) {
        studioTable.remove(id);
    }

    public Studio findStudio(int id) {
        return studioTable.findById(id);
    }

    public List<Studio> findAllStudios() {
        return studioTable.findAll();
    }

    public void printAllStudios() {
        List<Studio> studioList = findAllStudios();

        if(studioList.isEmpty()) {
            System.out.println("There is no studios.");
            return;
        }

        for (Studio studio : studioList) {
            System.out.println("Studio id: " + studio.getId());
            System.out.println("Name: " + studio.getName() + '\n');
        }
    }

    public void printStudio(int id) {
        Studio studio = findStudio(id);
        if(studio == null) {
            System.out.println("There is no studio with this id.");
            return;
        }

        System.out.println("Music id: " + studio.getId());
        System.out.println("Name: " + studio.getName());
        System.out.println("Country: " + countryTable.findById(studio.getCountryId()).getName());
        System.out.println("City: " + studio.getCity() + '\n');
    }
}
