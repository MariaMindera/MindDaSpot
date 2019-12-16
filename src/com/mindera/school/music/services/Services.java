package com.mindera.school.music.services;

import static com.mindera.school.music.data.tables.Tables.*;

public class Services {
    public static final MusicService MUSIC_SERVICE = new MusicService(MUSIC_TABLE, COUNTRY_TABLE, GENRE_TABLE);
    public static final AlbumService ALBUM_SERVICE = new AlbumService();
    public static final GenreService GENRE_SERVICE = new GenreService(GENRE_TABLE);
    public static final StudioService STUDIO_SERVICE = new StudioService(STUDIO_TABLE, COUNTRY_TABLE);
    public static final UserService USER_SERVICE = new UserService();
}
