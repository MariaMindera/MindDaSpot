package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Album;
import com.mindera.school.music.data.rows.Music;

public class AlbumTable extends Table<Album> {
    public void addMusicToAlbum(Music music, int albumId) {
        for (Album album : backend) {
            if (album.getId() == albumId) {
                album.addMusicToAlbum(music);
            }
        }
    }
}
