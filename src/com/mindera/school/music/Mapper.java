package com.mindera.school.music;

import com.mindera.school.music.data.rows.Country;
import com.mindera.school.music.data.rows.Genre;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.GenreTable;

public class Mapper {
    private CountryTable countryTable;
    private GenreTable genreTable;

    public Mapper(CountryTable countryTable, GenreTable genreTable) {
        this.countryTable = countryTable;
        this.genreTable = genreTable;
    }

    public int getCountryIdByName(String name) {
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        int id = countryTable.findIdByName(name);
        if (id == 0) {
            id = countryTable.getNewId();
            countryTable.add(new Country(id, name));
        }
        return id;
    }

    public int getGenreIdByName(String name) {
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        int id = genreTable.findIdByName(name);
        if (id == 0) {
            id = genreTable.getNewId();
            genreTable.add(new Genre(id, name));
        }
        return id;
    }
}
