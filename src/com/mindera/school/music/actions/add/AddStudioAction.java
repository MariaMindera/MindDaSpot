package com.mindera.school.music.actions.add;

import com.mindera.school.music.services.StudioService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.*;

public class AddStudioAction implements Action {
    private StudioService studioService;

    public AddStudioAction() {
        this.studioService = STUDIO_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the studio: ");
        request.hasString("City", "Insert the name of the city: ");
        request.hasString("Country", "Insert the name of the country: ");
        studioService.add(request.ask());
    }
}
