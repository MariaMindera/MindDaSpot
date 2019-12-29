package com.mindera.school.music.actions.others;

import com.mindera.school.music.actions.rows.AlbumUserMenu;
import com.mindera.school.music.actions.rows.ArtistUserMenu;
import com.mindera.school.music.actions.rows.MusicUserMenu;
import com.mindera.school.music.actions.rows.PlaylistUserMenu;
import com.mindera.school.music.data.rows.Playlist;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MenuUserAction implements Action {
    private Menu menu;

    public MenuUserAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new LogoutAction()), true);
        menu.add(new Option("Music", new MusicUserMenu()));
        menu.add(new Option("Album", new AlbumUserMenu()));
        menu.add(new Option("Artist", new ArtistUserMenu()));
        menu.add(new Option("Playlist", new PlaylistUserMenu()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        System.out.println();
        menu.render();
    }
}
