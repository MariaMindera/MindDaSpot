package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.ui.Mapper;
import com.mindera.school.music.data.rows.Album;
import com.mindera.school.music.data.tables.AlbumTable;
import com.mindera.school.music.ui.KeyValue;

import java.time.Year;
import java.util.List;

import static com.mindera.school.music.data.tables.Tables.*;
import static com.mindera.school.music.services.Services.*;

public class AlbumService {
    AlbumTable albumTable;
    StudioService studioService;
    Mapper mapper;

    public AlbumService() {
        this.albumTable = ALBUM_TABLE;
        this.studioService = STUDIO_SERVICE;
        this.mapper = new Mapper();
    }

    public void add(List<KeyValue> keyValueList) {
        Album album = new Album();

        album.setId(albumTable.getNewId());

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (albumTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This Studio already exits.");
                    return;
                }
                album.setName(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Year")) {
                album.setYear((Year) keyValue.getValue());
            }
            if (keyValue.getName().equals("Studio")) {
                album.setStudioId(mapper.getStudioIdByName(keyValue.getValue().toString()));
            }
        }

        albumTable.add(album);
    }

    public void removeAlbum(int id) {
        albumTable.remove(id);
    }

    public Album findAlbum(int id) {
        return albumTable.findById(id);
    }

    public List<Album> findAllAlbums() {
        return albumTable.findAll();
    }

    public void printAllAlbums() {
        List<Album> albumList = findAllAlbums();

        if (albumList.isEmpty()) {
            System.out.println("There is no album.");
            return;
        }

        for (Album album : albumList) {
            System.out.println("Album id: " + album.getId());
            System.out.println("Name: " + album.getName());
            System.out.println("Number of Likes: " + album.getNrLikes() + '\n');
        }
    }

    public void printAlbum(int id) {
        Album album = findAlbum(id);
        if (album == null) {
            System.out.println("There is no album with this id.");
            return;
        }

        System.out.println("Genre id: " + album.getId());
        System.out.println("Name: " + album.getName());
        System.out.println("Year: " + album.getYear());
        System.out.println("Studio: " + studioService.findStudio(album.getStudioId()).getName());
        System.out.println("Number of Likes: " + album.getNrLikes());
        System.out.println("Number of Searches: " + album.getNrSearch());
        System.out.println("Musics: ");

        List<Music> musicList = album.getMusicList();
        for (Music music : musicList) {
            System.out.print("Id: " + music.getId() + " Name: " + music.getName() + '\n');
        }
    }
}
