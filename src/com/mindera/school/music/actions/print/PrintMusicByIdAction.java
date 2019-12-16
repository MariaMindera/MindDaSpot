package com.mindera.school.music.actions.print;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;

import java.util.Scanner;

public class PrintMusicByIdAction implements Action {
    private final Scanner SCANNER = new Scanner(System.in);
    private MusicService musicService;

    public PrintMusicByIdAction(MusicService musicService) {
        this.musicService = musicService;
    }

    @Override
    public void execute() {
        System.out.print("Insert id of the song: ");
        musicService.printMusic(SCANNER.nextInt());
    }
}
