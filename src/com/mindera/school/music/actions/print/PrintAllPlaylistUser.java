package com.mindera.school.music.actions.print;

import com.mindera.school.music.services.PlaylistService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.PLAYLIST_SERVICE;

public class PrintAllPlaylistUser implements Action {
    private PlaylistService playlistService;

    public PrintAllPlaylistUser() {
        this.playlistService = PLAYLIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        System.out.println();
        playlistService.printAllUser();
    }
}
