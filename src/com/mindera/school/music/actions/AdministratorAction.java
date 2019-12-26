package com.mindera.school.music.actions;

import com.mindera.school.music.services.UserService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import static com.mindera.school.music.services.Services.USER_SERVICE;

import java.sql.SQLException;

public class AdministratorAction implements Action {
    private Request request;
    private UserService userService;

    public AdministratorAction() {
        this.request = new Request();
        this.userService = USER_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        request.hasString("Email", "Email:");
        request.hasString("Password", "Password:");
        userService.userOnline(request.ask());
    }
}
