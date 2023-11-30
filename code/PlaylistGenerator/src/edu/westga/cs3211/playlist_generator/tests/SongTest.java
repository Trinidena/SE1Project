package edu.westga.cs3211.playlist_generator_tests;
import static org.junit.Assert.*;
import org.junit.Test;
import edu.westga.cs3211.playlist_generator.model.Song;

public class SongTest {

	@Test
    public void testSongConstructor() {
        // Test valid constructor
        Song song = new Song("Title", "Artist", "Genre");
        assertEquals("Title", song.getSongTitle());
        assertEquals("Artist", song.getArtist());
        assertEquals("Genre", song.getGenre());

        // Test constructor with null parameters
        assertThrows(IllegalArgumentException.class, () -> {
            new Song(null, "Artist", "Genre");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Song("Title", null, "Genre");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Song("Title", "Artist", null);
        });

        // Test constructor with all null parameters
        assertThrows(IllegalArgumentException.class, () -> {
            new Song(null, null, null);
        });
    }

    @Test
    public void testGetSongTitle() {
        Song song = new Song("Title", "Artist", "Genre");
        assertEquals("Title", song.getSongTitle());
    }

    @Test
    public void testGetArtist() {
        Song song = new Song("Title", "Artist", "Genre");
        assertEquals("Artist", song.getArtist());
    }

    @Test
    public void testGetGenre() {
        Song song = new Song("Title", "Artist", "Genre");
        assertEquals("Genre", song.getGenre());
    }

    @Test
    public void testGetAlbum() {
        Song song = new Song("Title", "Artist", "Genre");
        // By default, the album is not set, expecting null
        assertNull(song.getAlbum());
    }

    @Test
    public void testGetRank() {
        Song song = new Song("Title", "Artist", "Genre");
        // By default, the rank is not set, expecting null
        assertNull(song.getRank());
    }

    @Test
    public void testGetYear() {
        Song song = new Song("Title", "Artist", "Genre");
        // By default, the year is not set, expecting null
        assertNull(song.getYear());
    }

    @Test
    public void testGetTag() {
        Song song = new Song("Title", "Artist", "Genre");
        // By default, the tag is not set, expecting null
        assertNull(song.getTag());
    }
    
    @Test
    public void testToString() {
        Song song = new Song("Title", "Artist", "Genre");
        assertEquals("Title Artist Genre", song.toString());
    }
}
