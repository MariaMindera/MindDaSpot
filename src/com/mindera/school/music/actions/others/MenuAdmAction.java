package com.mindera.school.music.actions.others;

import com.mindera.school.music.actions.album.AlbumMenuAdmAction;
import com.mindera.school.music.actions.artist.ArtistMenuAdmAction;
import com.mindera.school.music.actions.country.CountryMenuAdmAction;
import com.mindera.school.music.actions.genre.GenreMenuAdmAction;
import com.mindera.school.music.actions.music.MusicMenuAdmAction;
import com.mindera.school.music.actions.playlist.PlaylistMenuAdmAction;
import com.mindera.school.music.actions.producer.ProducerMenuAdmAction;
import com.mindera.school.music.actions.studio.StudioMenuAdmAction;
import com.mindera.school.music.actions.user.UserMenuAdmAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MenuAdmAction implements Action {
    private Menu menu;

    public MenuAdmAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Album", new AlbumMenuAdmAction()));
        menu.add(new Option("Artist", new ArtistMenuAdmAction()));
        menu.add(new Option("Country", new CountryMenuAdmAction()));
        menu.add(new Option("Genre", new GenreMenuAdmAction()));
        menu.add(new Option("Music", new MusicMenuAdmAction()));
        menu.add(new Option("Playlist", new PlaylistMenuAdmAction()));
        menu.add(new Option("Producer", new ProducerMenuAdmAction()));
        menu.add(new Option("Studio", new StudioMenuAdmAction()));
        menu.add(new Option("User", new UserMenuAdmAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
