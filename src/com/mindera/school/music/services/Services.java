package com.mindera.school.music.services;

import com.mindera.school.music.ui.SQLConnection;

public class Services {
    public static final UserOnline USER_ONLINE = new UserOnline();
    public static final SQLConnection SQL_CONNECTION = new SQLConnection();
    public static final AlbumService ALBUM_SERVICE = new AlbumService();
    public static final ArtistService ARTIST_SERVICE = new ArtistService();
    public static final CountryService COUNTRY_SERVICE = new CountryService();
    public static final GenreService GENRE_SERVICE = new GenreService();
    public static final MusicService MUSIC_SERVICE = new MusicService();
    public static final PlaylistService PLAYLIST_SERVICE = new PlaylistService();
    public static final ProducerService PRODUCER_SERVICE = new ProducerService();
    public static final StudioService STUDIO_SERVICE = new StudioService();
    public static final UserService USER_SERVICE = new UserService();
}
