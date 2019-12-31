package com.mindera.school.music.actions.album;

import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;

import static com.mindera.school.music.services.Services.*;

import java.sql.SQLException;

public class PrintAllLikedAlbumsAction implements Action {
    private AlbumService albumService;

    public PrintAllLikedAlbumsAction() {
        this.albumService = ALBUM_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        albumService.printLikedAlbums();
    }
}
