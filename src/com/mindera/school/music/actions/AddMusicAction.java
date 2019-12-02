package com.mindera.school.music.actions;

import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.ui.Action;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Scanner;


public class AddMusicAction implements Action {
    private final Scanner sc = new Scanner(System.in);

    public AddMusicAction() {
    }

    @Override
    public void execute() {
        Music music = new Music();
        System.out.println("Introduza o nome da musica:");
        music.setName(sc.nextLine().trim());

        System.out.println("Introduza o ano da musica:");
        music.setYear(Year.parse(sc.nextLine()));

        System.out.println("Introduza a duraçao");
        music.setDuration();

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
//        music.setCountryId();
//        music.setDuration();
//        music.setExplicit();
//        music.setGenreId();
//        music.setId();
//        music.setSpotifyURL();
//        music.setYoutubeURL();


    }
}
