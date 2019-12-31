package com.mindera.school.music.actions.playlist;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class PlaylistMenuUserAction implements Action {
    private Menu menu;

    public PlaylistMenuUserAction() {
        menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("My playlists", new PrintPlaylistMenuUserAction()));
        menu.add(new Option("Add new Playlist", new AddPlaylistAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
