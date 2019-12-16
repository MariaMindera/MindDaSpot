package com.mindera.school.music.actions.list;

import com.mindera.school.music.actions.ExitOption;
import com.mindera.school.music.actions.NoAction;
import com.mindera.school.music.actions.print.PrintAlbumByIdAction;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import static com.mindera.school.music.services.Services.ALBUM_SERVICE;

public class ListAlbumsAction implements Action {
    private Menu menu;

    public ListAlbumsAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Print album by id", new PrintAlbumByIdAction(ALBUM_SERVICE)));
        menu.add(new Option("Print all albums", new PrintAllAlbumsAction(ALBUM_SERVICE)));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() {
        menu.render();
    }
}
