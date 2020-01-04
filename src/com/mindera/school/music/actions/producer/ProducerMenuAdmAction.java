package com.mindera.school.music.actions.producer;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class ProducerMenuAdmAction implements Action {
    private Menu menu;

    public ProducerMenuAdmAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add producer", new AddProducerAction()));
        menu.add(new Option("Print all producers", new PrintAllProducersAction()));
        menu.add(new Option("Delete producer", new DeleteProducerAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
