package com.mindera.school.music.actions.add;

import com.mindera.school.music.services.UserService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

public class AddUserAction implements Action {
    UserService userService;
    Request request;

    public AddUserAction(UserService userService) {
        this.userService = userService;
        this.request = new Request();
    }

    @Override
    public void execute() {
        request.hasString("Name", "Whats your name?");
        request.hasInt();
    }
}
