package com.mindera.school.music.actions.others;

import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class UserAction implements Action {
    private Menu menu;

    public UserAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Login", new LoginAction()));
        menu.add(new Option("Register", new RegisterAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
