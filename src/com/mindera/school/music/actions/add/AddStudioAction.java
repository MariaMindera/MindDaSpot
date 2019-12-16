package com.mindera.school.music.actions.add;

import com.mindera.school.music.services.StudioService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import static com.mindera.school.music.services.Services.*;

public class AddStudioAction implements Action {
    StudioService studioService;
    Request request;

    public AddStudioAction() {
        this.studioService = STUDIO_SERVICE;
        this.request = new Request();
    }

    @Override
    public void execute() {
        request.hasString("Name", "Insert the name of the studio: ");
        request.hasString("City", "Insert the name of the city: ");
        request.hasString("Country", "Insert the name of the country: ");
        studioService.add(request.ask());
    }
}
