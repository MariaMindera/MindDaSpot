package com.mindera.school.music.data.intermediateRows;

import com.mindera.school.music.data.intermediateTables.*;

public class IntermediateTables {
    public static final AlbumArtistTable ALBUM_ARTIST_TABLE = new AlbumArtistTable("album", "artist");
    public static final AlbumProducerTable ALBUM_PRODUCER_TABLE = new AlbumProducerTable("album", "producer");
    public static final FavouriteArtistTable FAVOURITE_ARTIST_TABLE = new FavouriteArtistTable("favourite", "artist");
    public static final FavouriteMusicTable FAVOURITE_MUSIC_TABLE = new FavouriteMusicTable("favourite", "music");
    public static final MusicAlbumTable MUSIC_ALBUM_TABLE = new MusicAlbumTable("music", "album");
    public static final MusicPlaylistTable MUSIC_PLAYLIST_TABLE = new MusicPlaylistTable("music", "playlist");
}
