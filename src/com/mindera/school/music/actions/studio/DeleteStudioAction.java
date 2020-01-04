package com.mindera.school.music.actions.studio;

import com.mindera.school.music.services.StudioService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.STUDIO_SERVICE;

public class DeleteStudioAction implements Action {
    private StudioService studioService;

    public DeleteStudioAction() {
        this.studioService = STUDIO_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the studio: ");
        studioService.removeByName(request.ask().get(0).getValue().toString());
    }
}
