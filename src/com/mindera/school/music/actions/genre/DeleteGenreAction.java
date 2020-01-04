package com.mindera.school.music.actions.genre;

import com.mindera.school.music.services.GenreService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.GENRE_SERVICE;

public class DeleteGenreAction implements Action {
    private GenreService genreService;

    public DeleteGenreAction() {
        this.genreService = GENRE_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the genre: ");
        genreService.removeByName(request.ask().get(0).getValue().toString());
    }
}
