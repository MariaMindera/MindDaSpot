package com.mindera.school.music.actions.music;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MusicMenuUserAction implements Action {
    private Menu menu;

    public MusicMenuUserAction() {
        menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add new music", new AddMusicAction()));
        menu.add(new Option("Print a music", new PrintMusicAction()));
        menu.add(new Option("Print all musics", new PrintAllMusicsAction()));
        menu.add(new Option("Like a music", new GiveLikeMusicAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        System.out.println();
        menu.render();
    }
}
