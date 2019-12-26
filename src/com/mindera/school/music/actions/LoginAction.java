package com.mindera.school.music.actions;

import com.mindera.school.music.services.SQLConnection;
import com.mindera.school.music.services.UserService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.*;

public class LoginAction implements Action {
    private UserService userService;
    private SQLConnection sql;
    private Request request;
    private MenuUserAction menuUserAction;

    public LoginAction() {
        this.userService = USER_SERVICE;
        this.sql = SQL_CONNECTION;
        this.request = new Request();
        this.menuUserAction = new MenuUserAction();
    }

    @Override
    public void execute() throws SQLException {
        request.hasString("Email", "Email:");
        request.hasString("Password", "Password:");
        userService.userOnline(request.ask());

    }
}
