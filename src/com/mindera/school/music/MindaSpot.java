package com.mindera.school.music;

import com.mindera.school.music.actions.AdministratorAction;
import com.mindera.school.music.actions.ExitOption;
import com.mindera.school.music.actions.UserAction;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MindaSpot {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.add(new Option("User", new UserAction()));
        menu.add(new Option("Administrator", new AdministratorAction()));
        menu.add(new Option("Exit", new ExitOption()));
        menu.render();
    }
}
