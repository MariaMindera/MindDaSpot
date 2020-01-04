package com.mindera.school.music.actions.album;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class AlbumMenuAdmAction implements Action {
    private Menu menu;

    public AlbumMenuAdmAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add Album", new AddAlbumAction()));
        menu.add(new Option("Add music to album", new AddMusicAlbumAction()));
        menu.add(new Option("Print an album", new PrintAlbumAction()));
        menu.add(new Option("Print all albums", new PrintAllAlbumsAction()));
        menu.add(new Option("Delete an album", new DeleteAlbumAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
