package com.mindera.school.music.actions;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;

public class PrintAllMusicsAction implements Action {
    private MusicService musicService;

    public PrintAllMusicsAction(MusicService musicService) {
        this.musicService = musicService;
    }

    @Override
    public void execute() {
        musicService.printAllMusics();
    }
}
