package com.mindera.school.music.actions.playlist;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class PrintPlaylistMenuUserAction implements Action {
    private Menu menu;

    public PrintPlaylistMenuUserAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Print a playlist", new PrintPlaylistUserAction()));
        menu.add(new Option("Print all playlists", new PrintAllPlaylistsUserAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
