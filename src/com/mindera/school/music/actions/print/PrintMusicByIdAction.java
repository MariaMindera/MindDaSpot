package com.mindera.school.music.actions.print;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;

import static com.mindera.school.music.services.Services.*;

import java.util.Scanner;

public class PrintMusicByIdAction implements Action {
    private final Scanner SCANNER = new Scanner(System.in);
    private MusicService musicService;

    public PrintMusicByIdAction() {
        this.musicService = MUSIC_SERVICE;
    }

    @Override
    public void execute() {
        System.out.print("Insert id of the song: ");
        musicService.printMusic(SCANNER.nextInt());
    }
}
