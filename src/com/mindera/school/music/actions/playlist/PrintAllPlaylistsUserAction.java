package com.mindera.school.music.actions.playlist;

import com.mindera.school.music.services.PlaylistService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.PLAYLIST_SERVICE;

public class PrintAllPlaylistsUserAction implements Action {
    private PlaylistService playlistService;

    public PrintAllPlaylistsUserAction() {
        this.playlistService = PLAYLIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        playlistService.printAllUser();
    }
}
