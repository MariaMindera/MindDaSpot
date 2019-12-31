package com.mindera.school.music;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.LoginAction;
import com.mindera.school.music.actions.user.RegisterAction;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class MindaSpot {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.add(new Option("Login", new LoginAction()));
        menu.add(new Option("Register", new RegisterAction()));
        menu.add(new Option("Exit", new ExitOption()));
        menu.render();
    }
}