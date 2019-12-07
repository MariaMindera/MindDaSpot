package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.tables.MusicTable;

import java.util.List;

public class MusicService {
    MusicTable musicTable;

    public MusicService() {
        this.musicTable = new MusicTable();
    }

    public void addMusic(Music music) {
        music.setId(musicTable.getNewId() + 1);
        musicTable.add(music);
    }

    public void removeMusic(int id) {
        musicTable.remove(id);
    }

    public Music findMusic(int id) {
        return musicTable.find(id);
    }

    public List<Music> findAllMusics() {
        return musicTable.findAll();
    }
}