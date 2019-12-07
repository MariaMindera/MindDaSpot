package com.mindera.school.music;

import com.mindera.school.music.actions.MusicAction;
import com.mindera.school.music.actions.NoAction;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add(new Option("Music", new MusicAction()));
        menu.add(new Option("Exit", new NoAction()), true);
        menu.render();
    }
}