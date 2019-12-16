package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Album;
import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.rows.Playlist;

public class PlaylistTable extends Table<Playlist> {
    public void addMusicToPlaylist(Music music, int playlistId) {
        for (Playlist playlist : backend) {
            if (playlist.getId() == playlistId) {
                playlist.addMusicToPlaylist(music);
            }
        }
    }
}
