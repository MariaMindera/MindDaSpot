package com.mindera.school.music.actions.user;

import com.mindera.school.music.services.UserService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.USER_SERVICE;

public class DeleteUserAction implements Action {
    private UserService userService;

    public DeleteUserAction() {
        this.userService = USER_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the user: ");
        userService.removeByName(request.ask().get(0).getValue().toString());
    }
}
