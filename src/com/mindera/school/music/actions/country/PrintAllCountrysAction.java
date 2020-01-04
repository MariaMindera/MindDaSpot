package com.mindera.school.music.actions.country;

import com.mindera.school.music.services.CountryService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.COUNTRY_SERVICE;

public class PrintAllCountrysAction implements Action {
    private CountryService countryService;

    public PrintAllCountrysAction() {
        this.countryService = COUNTRY_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        countryService.printAll();
    }
}
