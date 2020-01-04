package com.mindera.school.music.actions.music;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MusicMenuUserAction implements Action {
    private Menu menu;

    public MusicMenuUserAction() {
        menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add music", new AddMusicAction()));
        menu.add(new Option("Print a music", new PrintMusicAction()));
        menu.add(new Option("Print all musics", new PrintAllMusicsAction()));
        menu.add(new Option("Print all liked musics", new PrintAllLikedMusicsAction()));
        menu.add(new Option("Print all musics by genre", new PrintAllMusicsGenreAction()));
        menu.add(new Option("Print all musics by country", new PrintAllMusicsCountryAction()));
        menu.add(new Option("Like music", new LikeMusicAction()));
        menu.add(new Option("Unlike music", new UnlikeMusicAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
