package com.mindera.school.music.actions.music;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.MUSIC_SERVICE;

public class PrintAllMusicsCountryAction implements Action {
    private MusicService musicService;

    public PrintAllMusicsCountryAction() {
        this.musicService = MUSIC_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the country: ");
        musicService.printMusicsByCountry(request.ask().get(0).getValue().toString());
    }
}
