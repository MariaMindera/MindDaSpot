package com.mindera.school.music.actions.print;

import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;

public class PrintAlbumByIdAction implements Action {
    AlbumService albumService;
    public PrintAlbumByIdAction(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Override
    public void execute() {
        System.out.print("Insert id of the album: ");
        albumService.printAlbum(SCANNER.nextInt());
    }
}
