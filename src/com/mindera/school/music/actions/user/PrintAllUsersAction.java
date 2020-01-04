package com.mindera.school.music.actions.user;

import com.mindera.school.music.services.UserService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.USER_SERVICE;

public class PrintAllUsersAction implements Action {
    private UserService userService;

    public PrintAllUsersAction() {
        this.userService = USER_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        userService.printAll();
    }
}
