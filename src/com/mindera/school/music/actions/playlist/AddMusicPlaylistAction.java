package com.mindera.school.music.actions.playlist;

import com.mindera.school.music.services.PlaylistService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.services.Services.PLAYLIST_SERVICE;

public class AddMusicPlaylistAction implements Action {
    private PlaylistService playlistService;

    public AddMusicPlaylistAction() {
        this.playlistService = PLAYLIST_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Playlist", "Insert the name of the playlist: ");
        request.hasString("Music", "Insert the name of the music: ");
        List<KeyValue> list = request.ask();
        playlistService.addMusicPlaylist(list.get(0).getValue().toString(), list.get(1).getValue().toString());
    }
}
