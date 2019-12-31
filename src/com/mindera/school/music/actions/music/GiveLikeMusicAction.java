package com.mindera.school.music.actions.music;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import static com.mindera.school.music.services.Services.MUSIC_SERVICE;

import java.sql.SQLException;

public class GiveLikeMusicAction implements Action {
    private MusicService musicService;

    public GiveLikeMusicAction() {
        this.musicService = MUSIC_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "What is the name of the song?");
        musicService.addLike((String) request.ask().get(0).getValue());
    }
}
