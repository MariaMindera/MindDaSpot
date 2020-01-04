package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Genre;
import com.mindera.school.music.data.tables.GenreTable;
import com.mindera.school.music.ui.KeyValue;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.data.tables.Tables.GENRE_TABLE;

public class GenreService {
    private GenreTable genreTable;

    public GenreService() {
        this.genreTable = GENRE_TABLE;
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        Genre genre = new Genre();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (genreTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This genre already exits.");
                    return;
                }
                genre.setName(keyValue.getValue().toString());
            }
        }

        genreTable.add(genre);
    }

    public void removeByName(String name) throws SQLException {
        int id = findIdByName(name);
        if (id == 0) {
            System.out.println("This genre doesn't exists.");
        } else {
            genreTable.removeById(id);
        }
    }

    public int findIdByName(String name) throws SQLException {
        return genreTable.findIdByName(name);
    }

    public Genre find(int id) throws SQLException {
        return genreTable.findById(id);
    }

    public List<Genre> findAll() throws SQLException {
        return genreTable.findAll();
    }

    public void printAll() throws SQLException {
        List<Genre> genreList = findAll();

        if (genreList.isEmpty()) {
            System.out.println("There is no genres.");
            return;
        }

        for (Genre genre : genreList) {
            System.out.println("Genre id: " + genre.getId());
            System.out.println("Name: " + genre.getName() + '\n');
        }
    }

    public void print(int id) throws SQLException {
        Genre genre = find(id);

        if (genre == null) {
            System.out.println("There is no genre.");
            return;
        }

        System.out.println("Genre id: " + genre.getId());
        System.out.println("Name: " + genre.getName() + '\n');
    }
}
