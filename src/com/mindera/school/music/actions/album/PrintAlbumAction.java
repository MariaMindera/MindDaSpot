package com.mindera.school.music.actions.album;

import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.services.Services.ALBUM_SERVICE;

public class PrintAlbumAction implements Action {
    private AlbumService albumService;

    public PrintAlbumAction() {
        albumService = ALBUM_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the album: ");

        albumService.print(albumService.findIdByName((String) request.ask().get(0).getValue()));
    }
}
