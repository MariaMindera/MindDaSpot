package com.mindera.school.music.actions.music;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.MUSIC_SERVICE;

public class PrintAllMusicsAction implements Action {
    private MusicService musicService;

    public PrintAllMusicsAction() {
        musicService = MUSIC_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        musicService.printAll();
    }
}
