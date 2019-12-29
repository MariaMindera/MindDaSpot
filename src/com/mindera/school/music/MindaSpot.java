package com.mindera.school.music;

import com.mindera.school.music.actions.others.AdministratorAction;
import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.UserAction;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MindaSpot {
    public static void main(String[] args) throws SQLException {
        System.out.println();
        Menu menu = new Menu();
        menu.add(new Option("User", new UserAction()));
        menu.add(new Option("Administrator", new AdministratorAction()));
        menu.add(new Option("Exit", new ExitOption()));
        menu.render();
    }
}
