package com.mindera.school.music.services;

import static com.mindera.school.music.data.tables.Tables.*;

public class Services {
    public static final MusicService MUSIC_SERVICE = new MusicService(MUSIC_TABLE, COUNTRY_TABLE, GENRE_TABLE);
}
