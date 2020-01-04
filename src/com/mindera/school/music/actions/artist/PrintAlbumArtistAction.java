package com.mindera.school.music.actions.artist;

import com.mindera.school.music.services.ArtistService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.ARTIST_SERVICE;

public class PrintAlbumArtistAction implements Action {
    private ArtistService artistService;

    public PrintAlbumArtistAction() {
        this.artistService = ARTIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the artist: ");
        artistService.printAllAlbums(request.ask().get(0).getValue().toString());
    }
}
