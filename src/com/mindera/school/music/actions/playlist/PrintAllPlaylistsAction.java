package com.mindera.school.music.actions.playlist;

import com.mindera.school.music.services.PlaylistService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.PLAYLIST_SERVICE;

public class PrintAllPlaylistsAction implements Action {
    private PlaylistService playlistService;

    public PrintAllPlaylistsAction() {
        this.playlistService = PLAYLIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        playlistService.printAll();
    }
}
