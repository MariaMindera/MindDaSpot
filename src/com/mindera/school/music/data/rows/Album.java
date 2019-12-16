package com.mindera.school.music.data.rows;

import com.mindera.school.music.data.Row;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Album implements Row {
    private int id;
    private String name;
    private Year year;
    private int nrSearch = 0;
    private int studioId;
    private int nrLikes = 0;
    private List<Music> musicList;

    public Album() {
        musicList = new ArrayList<>();
    }

    public void addMusicToAlbum(Music music) {
        this.musicList.add(music);
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getNrSearch() {
        return nrSearch;
    }

    public void setNrSearch() {
        this.nrSearch++;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public int getNrLikes() {
        return nrLikes;
    }

    public void setNrLikes() {
        this.nrLikes++;
    }

    public List<Music> getMusicList() {
        return musicList;
    }
}
