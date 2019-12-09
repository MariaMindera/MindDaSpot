package com.mindera.school.music.actions;

import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;
import static com.mindera.school.music.services.Services.*;

public class ListMusicsAction implements Action {
    private Menu menu;

    public ListMusicsAction() {
        this.menu = new Menu();
        menu.add(new Option("Back", new NoAction()), true);
        menu.add(new Option("Print music by id", new PrintMusicIdAction(MUSIC_SERVICE)));
        menu.add(new Option("Print all musics", new PrintAllMusicsAction(MUSIC_SERVICE)));
        menu.add(new Option("Exit", new ExitOption()));
    }

    @Override
    public void execute() {
        menu.render();
    }
}
