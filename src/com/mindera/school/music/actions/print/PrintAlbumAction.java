package com.mindera.school.music.actions.print;

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
        System.out.println();
        Request request = new Request();
        request.hasString("Name", "Insert the name of the album: ");
        List<KeyValue> list = request.ask();
        System.out.println();
        albumService.print(albumService.findByName((String) list.get(0).getValue()));
    }
}
