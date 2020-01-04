package com.mindera.school.music.actions.country;

import com.mindera.school.music.services.CountryService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.COUNTRY_SERVICE;

public class AddCountryAction implements Action {
    private CountryService countryService;

    public AddCountryAction() {
        this.countryService = COUNTRY_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the country: ");
        countryService.add(request.ask());
    }
}
