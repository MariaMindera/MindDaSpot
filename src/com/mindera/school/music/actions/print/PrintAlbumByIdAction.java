package com.mindera.school.music.actions.print;

import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;

import static com.mindera.school.music.services.Services.*;

public class PrintAlbumByIdAction implements Action {
    AlbumService albumService;

    public PrintAlbumByIdAction() {
        this.albumService = ALBUM_SERVICE;
    }

    @Override
    public void execute() {
        System.out.print("Insert id of the album: ");
        albumService.printAlbum(SCANNER.nextInt());
    }
}
