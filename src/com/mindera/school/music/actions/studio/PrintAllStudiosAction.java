package com.mindera.school.music.actions.studio;

import com.mindera.school.music.services.StudioService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.STUDIO_SERVICE;

public class PrintAllStudiosAction implements Action {
    private StudioService studioService;

    public PrintAllStudiosAction() {
        this.studioService = STUDIO_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        studioService.printAllStudios();
    }
}
