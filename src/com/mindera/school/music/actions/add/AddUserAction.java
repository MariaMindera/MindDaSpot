package com.mindera.school.music.actions.add;

import com.mindera.school.music.services.UserService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import static com.mindera.school.music.services.Services.*;

public class AddUserAction implements Action {
    UserService userService;
    Request request;

    public AddUserAction() {
        this.userService = USER_SERVICE;
        this.request = new Request();
    }

    @Override
    public void execute() {
        request.hasString("Name", "Whats your name?");
        request.hasInt();
    }
}
