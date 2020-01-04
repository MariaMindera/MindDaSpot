package com.mindera.school.music.data.rows;

import com.mindera.school.music.ui.StringCode;

public class Music {
    private int id;
    private String name;
    private String duration;
    private int year;
    private boolean explicit;
    private String spotifyURL;
    private String youtubeURL;
    private int nrSearch = 0;
    private int countryId;
    private int genreId;
    private int nrLikes = 0;
    private int album_id;

    public Music() {
    }

    public Music(int id, String name, String duration, int year, boolean explicit, String spotifyURL, String youtubeURL, int nrSearch, int countryId, int genreId, int nrLikes) {
        this.id = id;
        this.name = StringCode.capitalizeEachWord(name);
        this.duration = duration;
        this.year = year;
        this.explicit = explicit;
        this.spotifyURL = spotifyURL;
        this.youtubeURL = youtubeURL;
        this.nrSearch = nrSearch;
        this.countryId = countryId;
        this.genreId = genreId;
        this.nrLikes = nrLikes;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

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
        this.name = StringCode.capitalizeEachWord(name);
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public String getSpotifyURL() {
        return spotifyURL;
    }

    public void setSpotifyURL(String spotifyURL) {
        this.spotifyURL = spotifyURL;
    }

    public String getYoutubeURL() {
        return youtubeURL;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getNrLikes() {
        return nrLikes;
    }
}