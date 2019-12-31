package com.mindera.school.music.actions.playlist;

import com.mindera.school.music.services.PlaylistService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.PLAYLIST_SERVICE;

public class AddPlaylistAction implements Action {
    private PlaylistService playlistService;

    public AddPlaylistAction() {
        this.playlistService = PLAYLIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "What is the name of the playlist?");
        playlistService.add(request.ask());
    }
}
