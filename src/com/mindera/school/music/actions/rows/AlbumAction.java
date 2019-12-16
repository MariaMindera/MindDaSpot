package com.mindera.school.music.actions.rows;

import com.mindera.school.music.actions.ExitOption;
import com.mindera.school.music.actions.NoAction;
import com.mindera.school.music.actions.add.AddAlbumAction;
import com.mindera.school.music.actions.list.ListAlbumsAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

public class AlbumAction implements Action {
    private Menu menu;

    public AlbumAction() {
        menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Insert album", new AddAlbumAction()));
        menu.add(new Option("List albums", new ListAlbumsAction()));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() {
        menu.render();
    }
}
