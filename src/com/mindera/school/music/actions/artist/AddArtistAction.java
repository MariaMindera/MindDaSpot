package com.mindera.school.music.actions.artist;

import com.mindera.school.music.services.ArtistService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.services.Services.ARTIST_SERVICE;

public class AddArtistAction implements Action {
    private ArtistService artistService;
    private String name;

    public AddArtistAction() {
        this.artistService = ARTIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the artist: ");
        request.hasString("Country", "Insert the name of the country: ");
        request.hasString("Description", "Insert the description of the artist: ");
        List<KeyValue> list = request.ask();
        name = list.get(0).getValue().toString();
        artistService.add(list);
    }

    public String getName() {
        return name;
    }
}
