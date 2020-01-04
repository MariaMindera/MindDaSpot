package com.mindera.school.music.actions.music;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.MUSIC_SERVICE;

public class AddMusicAction implements Action {
    private MusicService musicService;

    public AddMusicAction() {
        this.musicService = MUSIC_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the song: ");
        request.hasString("Genre", "Insert the genre of the song: ");
        request.hasYear("Year", "Insert the year of the song: ");
        request.hasString("Duration", "Insert the duration of the song. [HHH:MM:SS]: ");
        request.hasString("Country", "Insert the country of the song: ");
        request.hasYesNo("Explicit", "Is the music explicit? [Y/N]: ");
        request.hasString("Album", "Insert the name of the album: ");
        request.hasString("SpotifyURL", "Insert the spotify url of the song: ");
        request.hasString("YoutubeURL", "Insert the youtube url of the song: ");
        musicService.add(request.ask());
    }
}
