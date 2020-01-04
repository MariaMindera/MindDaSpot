package com.mindera.school.music.actions.album;

import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.ALBUM_SERVICE;

public class LikeAlbumAction implements Action {
    private AlbumService albumService;

    public LikeAlbumAction() {
        this.albumService = ALBUM_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the album: ");
        albumService.addLikeAlbum(request.ask().get(0).getValue().toString());
    }
}
