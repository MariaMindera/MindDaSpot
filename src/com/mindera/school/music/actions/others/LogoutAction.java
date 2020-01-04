package com.mindera.school.music.actions.others;

import com.mindera.school.music.services.UserOnline;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.USER_ONLINE;

public class LogoutAction implements Action {
    private UserOnline userOnline;

    public LogoutAction() {
        this.userOnline = USER_ONLINE;
    }

    @Override
    public void execute() throws SQLException {
        userOnline.setUserID(-1);
    }
}
