package com.mindera.school.music.actions.country;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class CountryMenuAdmAction implements Action {
    private Menu menu;

    public CountryMenuAdmAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add country", new AddCountryAction()));
        menu.add(new Option("Print all countrys", new PrintAllCountrysAction()));
        menu.add(new Option("Delete country", new DeleteCountryAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
