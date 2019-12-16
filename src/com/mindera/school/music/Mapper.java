package com.mindera.school.music;

import com.mindera.school.music.data.rows.Country;
import com.mindera.school.music.data.rows.Genre;
import com.mindera.school.music.data.rows.User;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.GenreTable;

public class Mapper {
    private CountryTable countryTable;
    private GenreTable genreTable;
    private User user;

    public Mapper(CountryTable countryTable, GenreTable genreTable, User user) {
        this.countryTable = countryTable;
        this.genreTable = genreTable;
        this.user = user;
    }

    public Mapper(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public Mapper(GenreTable genreTable) {
        this.genreTable = genreTable;
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
}
