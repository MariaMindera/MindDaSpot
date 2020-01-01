package com.mindera.school.music.actions.playlist;

import com.mindera.school.music.services.PlaylistService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.services.Services.PLAYLIST_SERVICE;

public class PrintPlaylistAction implements Action {
    private PlaylistService playlistService;

    public PrintPlaylistAction() {
        this.playlistService = PLAYLIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "What is the name of the playlist?");

        List<KeyValue> list = request.ask();
        playlistService.print(playlistService.findIdByNameUser((String) list.get(0).getValue()));
    }
}
