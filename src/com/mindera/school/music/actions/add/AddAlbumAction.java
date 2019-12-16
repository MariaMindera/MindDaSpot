package com.mindera.school.music.actions.add;

import com.mindera.school.music.services.AlbumService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

public class AddAlbumAction implements Action {
    private AlbumService albumService;
    private Request request;

    public AddAlbumAction(AlbumService albumService) {
        this.albumService = albumService;
        this.request = new Request();
    }

    @Override
    public void execute() {
        request.hasString("Name", "Insert the name of the album: ");
        request.hasInt("Year", "Insert the year of the album: ");
        request.hasString("Studio", "Insert the name of the studio: ");
        albumService.addAlbum(request.ask());
    }
}
