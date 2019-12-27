package com.mindera.school.music.actions.others;

import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.SQL_CONNECTION;

public class ExitOption implements Action {
    @Override
    public void execute() throws SQLException {
        SQL_CONNECTION.closeConnection();
        System.exit(0);
    }
}
