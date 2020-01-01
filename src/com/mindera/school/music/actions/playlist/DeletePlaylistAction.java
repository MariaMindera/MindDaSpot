package com.mindera.school.music.actions.playlist;

import com.mindera.school.music.services.PlaylistService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.PLAYLIST_SERVICE;

public class DeletePlaylistAction implements Action {
    private PlaylistService playlistService;

    public DeletePlaylistAction() {
        this.playlistService = PLAYLIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the playlist: ");
        playlistService.removeByName(request.ask().get(0).getValue().toString());
    }
}
