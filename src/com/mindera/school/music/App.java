package com.mindera.school.music;

import com.mindera.school.music.actions.rows.AlbumAction;
import com.mindera.school.music.actions.rows.MusicAction;
import com.mindera.school.music.actions.NoAction;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

/*
 *
 * LOGIN WITH USER!!!???!!!
 *
 */

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add(new Option("Music", new MusicAction()));
        menu.add(new Option("Album", new AlbumAction()));
        menu.add(new Option("Exit", new NoAction()), true);
        menu.render();
    }
}