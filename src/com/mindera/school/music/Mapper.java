package com.mindera.school.music;

import com.mindera.school.music.actions.add.AddStudioAction;
import com.mindera.school.music.data.rows.Country;
import com.mindera.school.music.data.rows.Genre;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.GenreTable;
import com.mindera.school.music.data.tables.StudioTable;

import static com.mindera.school.music.data.tables.Tables.*;

public class Mapper {
    private CountryTable countryTable;
    private GenreTable genreTable;
    private StudioTable studioTable;

    public Mapper() {
        this.countryTable = COUNTRY_TABLE;
        this.genreTable = GENRE_TABLE;
        this.studioTable = STUDIO_TABLE;
    }

    public int getCountryIdByName(String name) {
        int id = countryTable.findIdByName(name);
        if (id == 0) {
            id = countryTable.getNewId();
            countryTable.add(new Country(id, name));
        }
        return id;
    }

    public int getGenreIdByName(String name) {
        int id = genreTable.findIdByName(name);
        if (id == 0) {
            id = genreTable.getNewId();
            genreTable.add(new Genre(id, name));
        }
        return id;
    }

    public int getStudioIdByName(String name) {
        int id = studioTable.findIdByName(name);
        if (id == 0) {
            new AddStudioAction();
        }
        return studioTable.findIdByName(name);
    }
}
