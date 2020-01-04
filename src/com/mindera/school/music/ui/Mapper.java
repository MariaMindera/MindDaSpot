package com.mindera.school.music.ui;

import com.mindera.school.music.actions.album.AddAlbumAction;
import com.mindera.school.music.actions.artist.AddArtistAction;
import com.mindera.school.music.actions.studio.AddStudioAction;
import com.mindera.school.music.data.rows.Country;
import com.mindera.school.music.data.rows.Genre;
import com.mindera.school.music.data.rows.Producer;
import com.mindera.school.music.data.tables.*;

import java.sql.SQLException;

import static com.mindera.school.music.data.tables.Tables.*;

public class Mapper {
    private CountryTable countryTable;
    private GenreTable genreTable;
    private StudioTable studioTable;
    private ProducerTable producerTable;
    private ArtistTable artistTable;
    private AlbumTable albumTable;

    public Mapper() {
        this.countryTable = COUNTRY_TABLE;
        this.genreTable = GENRE_TABLE;
        this.studioTable = STUDIO_TABLE;
        this.producerTable = PRODUCER_TABLE;
        this.artistTable = ARTIST_TABLE;
        this.albumTable = ALBUM_TABLE;
    }

    public int getCountryIdByName(String name) throws SQLException {
        name = StringCode.capitalizeEachWord(name);
        int id = countryTable.findIdByName(name);
        if (id == 0) {
            countryTable.add(new Country(id, name));
            id = countryTable.findIdByName(name);
        }
        return id;
    }

    public int getGenreIdByName(String name) throws SQLException {
        name = StringCode.capitalizeEachWord(name);
        int id = genreTable.findIdByName(name);
        if (id == 0) {
            genreTable.add(new Genre(id, name));
            id = genreTable.findIdByName(name);
        }
        return id;
    }

    public int getStudioIdByName(String name) throws SQLException {
        name = StringCode.capitalizeEachWord(name);
        int id = studioTable.findIdByName(name);
        if (id == 0) {
            System.out.println('\n' + "It is a new studio. Please insert the date." + '\n');
            AddStudioAction addStudioAction = new AddStudioAction();
            addStudioAction.execute();
            name = StringCode.capitalizeEachWord(addStudioAction.getName());
            id = studioTable.findIdByName(name);
        }
        return id;
    }

    public int getProducerIdByName(String name) throws SQLException {
        name = StringCode.capitalizeEachWord(name);
        int id = producerTable.findIdByName(name);
        if (id == 0) {
            producerTable.add(new Producer(name));
            id = producerTable.findIdByName(name);
        }
        return id;
    }

    public int getArtistIdByName(String name) throws SQLException {
        name = StringCode.capitalizeEachWord(name);
        int id = artistTable.findIdByName(name);
        if (id == 0) {
            System.out.println('\n' + "It is a new artist. Please insert the date." + '\n');
            AddArtistAction addArtistAction = new AddArtistAction();
            addArtistAction.execute();
            name = StringCode.capitalizeEachWord(addArtistAction.getName());
            id = artistTable.findIdByName(name);
        }
        return id;
    }

    public int getAlbumIdByName(String name) throws SQLException {
        name = StringCode.capitalizeEachWord(name);
        int id = albumTable.findIdByName(name);
        if (id == 0) {
            System.out.println('\n' + "It is a new album. Please insert the date." + '\n');
            AddAlbumAction addAlbumAction = new AddAlbumAction();
            addAlbumAction.execute();
            name = StringCode.capitalizeEachWord(addAlbumAction.getName());
            id = albumTable.findIdByName(name);
        }
        return id;
    }
}
