package com.mindera.school.music.actions.rows;

import com.mindera.school.music.actions.add.AddAlbumAction;
import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.actions.print.PrintAlbumAction;
import com.mindera.school.music.actions.print.PrintAllAlbumsAction;
import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import static com.mindera.school.music.services.Services.ALBUM_SERVICE;

import java.sql.SQLException;

public class AlbumUserMenu implements Action {
    private AlbumService albumService;
    private Menu menu;

    public AlbumUserMenu() {
        albumService = ALBUM_SERVICE;
        menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add new album", new AddAlbumAction()));
        menu.add(new Option("Print an album", new PrintAlbumAction()));
        menu.add(new Option("Print all albums", new PrintAllAlbumsAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
