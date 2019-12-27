package com.mindera.school.music.ui;

import com.mindera.school.music.actions.add.AddStudioAction;
import com.mindera.school.music.data.rows.Country;
import com.mindera.school.music.data.rows.Genre;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.GenreTable;
import com.mindera.school.music.data.tables.StudioTable;

import java.sql.SQLException;

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

    public int getCountryIdByName(String name) throws SQLException {
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        int id = countryTable.findIdByName(name);
        if (id == 0) {
            countryTable.add(new Country(id, name));
            id = countryTable.findIdByName(name);
        }
        return id;
    }

    public int getGenreIdByName(String name) throws SQLException {
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        int id = genreTable.findIdByName(name);
        if (id == 0) {
            genreTable.add(new Genre(id, name));
            id = genreTable.findIdByName(name);
        }
        return id;
    }

    public int getStudioIdByName(String name) throws SQLException {
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        int id = studioTable.findIdByName(name);
        if (id == 0) {
            System.out.println('\n' + "It is a new studio. Please insert the date." + '\n');
            new AddStudioAction().execute();
            id = studioTable.findIdByName(name);
        }
        return id;
    }
}
