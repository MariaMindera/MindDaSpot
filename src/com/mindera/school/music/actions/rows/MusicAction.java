package com.mindera.school.music.actions.rows;

import com.mindera.school.music.actions.ExitOption;
import com.mindera.school.music.actions.NoAction;
import com.mindera.school.music.actions.add.AddMusicAction;
import com.mindera.school.music.actions.list.ListMusicsAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import static com.mindera.school.music.services.Services.*;

public class MusicAction implements Action {
    Menu menu;

    public MusicAction() {
        menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Insert musics", new AddMusicAction(MUSIC_SERVICE)));
        menu.add(new Option("List musics", new ListMusicsAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() {
        menu.render();
    }
}
