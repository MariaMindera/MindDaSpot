package com.mindera.school.music.actions.print;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;

import static com.mindera.school.music.services.Services.*;

public class PrintAllMusicsAction implements Action {
    private MusicService musicService;

    public PrintAllMusicsAction() {
        this.musicService = MUSIC_SERVICE;
    }

    @Override
    public void execute() {
        musicService.printAllMusics();
    }
}
