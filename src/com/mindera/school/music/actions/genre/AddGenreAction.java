package com.mindera.school.music.actions.genre;

import com.mindera.school.music.services.GenreService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.GENRE_SERVICE;

public class AddGenreAction implements Action {
    private GenreService genreService;

    public AddGenreAction() {
        this.genreService = GENRE_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the country: ");
        genreService.add(request.ask());
    }
}
