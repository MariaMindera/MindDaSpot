package com.mindera.school.music.actions.others;

import com.mindera.school.music.actions.album.AlbumMenuUserAction;
import com.mindera.school.music.actions.artist.ArtistMenuUserAction;
import com.mindera.school.music.actions.music.MusicMenuUserAction;
import com.mindera.school.music.actions.playlist.PlaylistMenuUserAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MenuUserAction implements Action {
    private Menu menu;

    public MenuUserAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new LogoutAction()), true);
        menu.add(new Option("Album", new AlbumMenuUserAction()));
        menu.add(new Option("Artist", new ArtistMenuUserAction()));
        menu.add(new Option("Music", new MusicMenuUserAction()));
        menu.add(new Option("Playlist", new PlaylistMenuUserAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
