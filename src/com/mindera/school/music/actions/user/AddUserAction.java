package com.mindera.school.music.actions.user;

import com.mindera.school.music.services.UserService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.USER_SERVICE;

public class AddUserAction implements Action {
    private UserService userService;

    public AddUserAction() {
        this.userService = USER_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "What is your name? ");
        request.hasString("Birthdate", "What is your birthdate? [YYYY/MM/DD]: ");
        request.hasChar("Gender", "What is your gender? [F/M]: ");
        request.hasString("Country", "What is your country? ");
        request.hasString("Email", "What is your email? ");
        request.hasString("Password", "Set your password: ");
        userService.add(request.ask());
    }
}
