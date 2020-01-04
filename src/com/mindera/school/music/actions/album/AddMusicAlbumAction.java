package com.mindera.school.music.actions.album;

import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.services.Services.ALBUM_SERVICE;

public class AddMusicAlbumAction implements Action {
    private AlbumService albumService;

    public AddMusicAlbumAction() {
        this.albumService = ALBUM_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("NameAlbum", "Insert the name of the album: ");
        request.hasString("NameMusic", "Insert the name of the music: ");
        List<KeyValue> list = request.ask();
        albumService.addMusicToAlbum((String) list.get(1).getValue(), (String) list.get(0).getValue());
    }
}
