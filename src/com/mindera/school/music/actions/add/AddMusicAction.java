package com.mindera.school.music.actions.add;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import static com.mindera.school.music.services.Services.*;

/*
 *
 * Read Music from user and add in Music Service
 *
 */

public class AddMusicAction implements Action {
    private MusicService musicService;
    private Request request;

    public AddMusicAction() {
        this.musicService = MUSIC_SERVICE;
        this.request = new Request();
    }

    @Override
    public void execute() {
        request.hasString("Name", "Insert the name of the song: ");
        request.hasString("Genre", "Insert the genre of the song: ");
        request.hasYear("Year", "Insert the year of the song: ");
        request.hasInt("Duration", "Insert the duration of the song: ");
        request.hasString("Country", "Insert the country of the song: ");
        request.hasYesNo("Explicit", "Is the music explicit? [Y/N]: ");
        request.hasString("SpotifyURL", "Insert the spotify url of the song: ");
        request.hasString("YoutubeURL", "Insert the youtube url of the song: ");
        musicService.addMusic(request.ask());
    }
}
