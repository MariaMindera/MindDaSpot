package com.mindera.school.music.actions.artist;

import com.mindera.school.music.services.ArtistService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.ARTIST_SERVICE;

public class PrintAllFollowedArtistAction implements Action {
    private ArtistService artistService;

    public PrintAllFollowedArtistAction() {
        this.artistService = ARTIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        artistService.printFollowedArtist();
    }
}
