package com.mindera.school.music.actions.artist;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.LogoutAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class ArtistMenuUserAction implements Action {
    private Menu menu;

    public ArtistMenuUserAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new LogoutAction()), true);
        menu.add(new Option("Print an artist", new PrintArtistAction()));
        menu.add(new Option("Print all artists", new PrintAllArtistsAction()));
        menu.add(new Option("Print all albums from an artist", new PrintAlbumArtistAction()));
        menu.add(new Option("Print all musics from an artist", new PrintMusicArtistAction()));
        menu.add(new Option("Print followed artist", new PrintAllFollowedArtistAction()));
        menu.add(new Option("Follow an artist", new FollowArtistAction()));
        menu.add(new Option("Unfollow an artist", new UnfollowArtistAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
