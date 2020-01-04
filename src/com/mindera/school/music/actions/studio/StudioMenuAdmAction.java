package com.mindera.school.music.actions.studio;

import com.mindera.school.music.actions.others.ExitOption;
import com.mindera.school.music.actions.others.NoAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.sql.SQLException;

public class StudioMenuAdmAction implements Action {
    private Menu menu;

    public StudioMenuAdmAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Add studio", new AddStudioAction()));
        menu.add(new Option("Print all studios", new PrintAllStudiosAction()));
        menu.add(new Option("Delete studio", new DeleteStudioAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() throws SQLException {
        menu.render();
    }
}
