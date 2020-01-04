package com.mindera.school.music.actions.genre;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class GenreMenuAdmAction implements Action {
    private Menu menu;

    public GenreMenuAdmAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add genre", new AddGenreAction()));
        menu.add(new Option("Print all genres", new PrintAllGenresAction()));
        menu.add(new Option("Delete genre", new DeleteGenreAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
