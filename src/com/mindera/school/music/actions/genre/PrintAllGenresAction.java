package com.mindera.school.music.actions.genre;

import com.mindera.school.music.services.GenreService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.GENRE_SERVICE;

public class PrintAllGenresAction implements Action {
    private GenreService genreService;

    public PrintAllGenresAction() {
        this.genreService = GENRE_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        genreService.printAll();
    }
}
