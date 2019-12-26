package com.mindera.school.music.actions;

import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MenuUserAction implements Action {
    private Menu menu;

    public MenuUserAction() {
        this.menu = new Menu();
    }

    @Override
    public void execute() throws SQLException {
        menu.add(new Option("Back", new LogoutAction()), true);
        menu.render();
    }
}
