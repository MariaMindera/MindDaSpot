package com.mindera.school.music.actions.print;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;

import static com.mindera.school.music.services.Services.MUSIC_SERVICE;

import java.sql.SQLException;

public class PrintAllMusicsAction implements Action {
    private MusicService musicService;

    public PrintAllMusicsAction() {
        musicService = MUSIC_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        System.out.println();
        musicService.printAll();
    }
}
