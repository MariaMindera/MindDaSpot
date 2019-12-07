package com.mindera.school.music.actions;

import com.mindera.school.music.ui.Action;

public class ExitOption implements Action {
    @Override
    public void execute() {
        System.exit(0);
    }
}
