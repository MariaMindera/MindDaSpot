package com.mindera.school.music.actions.others;

import com.mindera.school.music.services.UserService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.USER_ONLINE;
import static com.mindera.school.music.services.Services.USER_SERVICE;

public class LoginAction implements Action {
    private UserService userService;

    public LoginAction() {
        this.userService = USER_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Email", "Email:");
        request.hasString("Password", "Password:");
        userService.userOnline(request.ask());

        if (USER_ONLINE.isAdm()) {
            new MenuAdmAction().execute();
        } else {
            new MenuUserAction().execute();
        }
    }
}
