package com.mindera.school.music.actions.user;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class UserMenuAdmAction implements Action {
    private Menu menu;

    public UserMenuAdmAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add User", new AddUserAction()));
        menu.add(new Option("Print all users", new PrintAllUsersAction()));
        menu.add(new Option("Print a user", new PrintUserAction()));
        menu.add(new Option("Delete user", new DeleteUserAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
