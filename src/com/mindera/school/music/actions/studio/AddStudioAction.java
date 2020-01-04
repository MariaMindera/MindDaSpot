package com.mindera.school.music.actions.studio;

import com.mindera.school.music.services.StudioService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.services.Services.STUDIO_SERVICE;

public class AddStudioAction implements Action {
    private StudioService studioService;
    private String name;

    public AddStudioAction() {
        this.studioService = STUDIO_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the studio: ");
        request.hasString("City", "Insert the name of the city: ");
        request.hasString("Country", "Insert the name of the country: ");
        List<KeyValue> list = request.ask();
        name = list.get(0).getValue().toString();
        studioService.add(list);
    }

    public String getName() {
        return name;
    }
}
