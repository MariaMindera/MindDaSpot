package com.mindera.school.music.actions;

import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import static com.mindera.school.music.services.Services.*;

public class MusicAction implements Action {
    Menu menu;

    public MusicAction() {
        menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Insert Musics", new AddMusicAction(MUSIC_SERVICE)));
        menu.add(new Option("List Musics", new ListMusicsAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() {
        menu.render();
    }
}
