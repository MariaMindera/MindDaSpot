package com.mindera.school.music.actions.artist;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class ArtistMenuAdmAction implements Action {
    private Menu menu;

    public ArtistMenuAdmAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add artist", new AddArtistAction()));
        menu.add(new Option("Print an artist", new PrintArtistAction()));
        menu.add(new Option("Print all artists", new PrintAllArtistsAction()));
        menu.add(new Option("Print all albums from an artist", new PrintAlbumArtistAction()));
        menu.add(new Option("Print all musics from an artist", new PrintMusicArtistAction()));
        menu.add(new Option("Delete an artist", new DeleteArtistAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
