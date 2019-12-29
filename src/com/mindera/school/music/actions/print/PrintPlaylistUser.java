package com.mindera.school.music.actions.print;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class PrintPlaylistUser implements Action {
    private Menu menu;

    public PrintPlaylistUser() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Print a playlist", new PrintPlaylistUserAction()));
        menu.add(new Option("Print all playlists", new PrintAllPlaylistUser()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        System.out.println();
        menu.render();
    }
}
