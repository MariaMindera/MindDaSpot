package com.mindera.school.music.actions.print;

import com.mindera.school.music.services.MusicService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import static com.mindera.school.music.services.Services.MUSIC_SERVICE;

import java.sql.SQLException;
import java.util.List;

public class PrintMusicAction implements Action {
    private MusicService musicService;

    public PrintMusicAction() {
        musicService = MUSIC_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the song: ");
        List<KeyValue> list = request.ask();
        musicService.print(musicService.findByName((String) list.get(0).getValue()));
    }
}
