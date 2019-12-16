package com.mindera.school.music.services;

import com.mindera.school.music.Mapper;
import com.mindera.school.music.data.rows.Genre;
import com.mindera.school.music.data.tables.GenreTable;
import com.mindera.school.music.ui.KeyValue;

import java.util.List;

public class GenreService {
    GenreTable genreTable;
    Mapper mapper;

    public GenreService(GenreTable genreTable) {
        this.genreTable = genreTable;
        this.mapper = new Mapper(genreTable);
    }

    public void add(List<KeyValue> keyValueList) {
        Genre genre = new Genre();

        genre.setId(genreTable.getNewId());

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                String name = genreTable.verifyExistsName(keyValue.getValue().toString());
                if(name.equals("")) {
                    return new ;
                }
            }
        }

        genreTable.add(genre);
    }

    public void removeGenre(int id) {
        genreTable.remove(id);
    }

    public Genre findGenre(int id) {
        return genreTable.findById(id);
    }

    public List<Genre> findAllGenres() {
        return genreTable.findAll();
    }

    public void printAllStudios() {
        List<Genre> genreList = findAllGenres();

        if(genreList.isEmpty()) {
            System.out.println("There is no genre.");
            return;
        }

        for (Genre genre : genreList) {
            System.out.println("Genre id: " + genre.getId());
            System.out.println("Name: " + genre.getName() + '\n');
        }
    }

    public void printGenre(int id) {
        Genre genre = findGenre(id);
        if(genre == null) {
            System.out.println("There is no genre with this id.");
            return;
        }

        System.out.println("Genre id: " + genre.getId());
        System.out.println("Name: " + genre.getName() + '\n');
    }
}
