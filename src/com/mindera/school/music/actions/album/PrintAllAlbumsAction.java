package com.mindera.school.music.actions.album;

import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.ALBUM_SERVICE;

public class PrintAllAlbumsAction implements Action {
    private AlbumService albumService;

    public PrintAllAlbumsAction() {
        this.albumService = ALBUM_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        albumService.printAll();
    }
}
