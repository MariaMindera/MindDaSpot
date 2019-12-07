package com.mindera.school.music.actions;

import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.ui.Action;

import java.time.Year;
import java.util.Scanner;


public class AddMusicAction implements Action {
    private final Scanner sc;

    public AddMusicAction() {
        sc = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Music music = new Music();

        System.out.print("Enter the name of the song:");
        music.setName(sc.nextLine().trim());

        System.out.print('\n' + "Enter genre of the song:");
        String genre = sc.nextLine().trim();


        //mapper
        //music - domain

        System.out.print('\n' + "Enter the year of the song:");
        int ano = sc.nextInt();
        while(ano > Integer.parseInt(String.valueOf(Year.now())) || ano < 0) {
            System.out.print('\n' + "Invalid year. Re-enter:");
            ano = sc.nextInt();
        }
        music.setYear(ano);

        System.out.print('\n' + "Enter duration in seconds:");
        music.setDuration(sc.nextInt());

        System.out.print('\n' + "Is the music explicit? [Y/N]");
        char explicit = sc.next().trim().charAt(0);
        while (true) {
            if (explicit == 'Y') {
                music.setExplicit(true);
                break;
            }
            if (explicit == 'N') {
                music.setExplicit(false);
                break;
            }
            System.out.print('\n' + "Invalid letter. Re-enter:");
            explicit = sc.next().charAt(0);
        }

        System.out.print('\n' + "Enter spotify url:");
        music.setSpotifyURL(sc.nextLine().trim());

        System.out.print('\n' + "Enter youtube url:");
        music.setYoutubeURL(sc.nextLine().trim());

        System.out.print('\n' + "Enter country of the song:");
        String country = sc.nextLine().trim();
    }
}
