package edu.westga.cs3211.playlist_generator.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.westga.cs3211.playlist_generator.model.Song;

/**
 * class provides tests for the Song model class
 * 
 * @author Trinidad
 * @version 1.0
 */
public class SongTest {

	@Test
	public void testSongConstructor() {
		// Test valid constructor
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "tag");
		assertEquals("Title", song.getSongTitle());
		assertEquals("Artist", song.getArtist());
		assertEquals("Genre", song.getGenre());

		// Test constructor with null parameters
		assertThrows(IllegalArgumentException.class, () -> {
			new Song(null, "Artist", "Genre", "Album", 0, 0, "tag");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Song("Title", null, "Genre", "Album", 0, 0, "tag");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Song("Title", "Artist", null, "Album", 0, 0, "tag");
		});

		// Test constructor with all null parameters
		assertThrows(IllegalArgumentException.class, () -> {
			new Song(null, null, null, "Album", 0, 0, "tag");
		});

		// Test constructor with empty title
		assertThrows(IllegalArgumentException.class, () -> {
			new Song("", "Artist", "Genre", "Album", 0, 0, "tag");
		});

		// Test constructor with empty artist
		assertThrows(IllegalArgumentException.class, () -> {
			new Song("Title", "", "Genre", "Album", 0, 0, "tag");
		});

		// Test constructor with too high year
		assertThrows(IllegalArgumentException.class, () -> {
			new Song("Title", "Artist", "Genre", "Album", 0, 9999, "tag");
		});

		// Test constructor with too low year
		assertThrows(IllegalArgumentException.class, () -> {
			new Song("Title", "Artist", "Genre", "Album", 0, 1, "tag");
		});
	}

	@Test
	public void testGetSongTitle() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");
		assertEquals("Title", song.getSongTitle());
	}

	@Test
	public void testGetArtist() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");
		assertEquals("Artist", song.getArtist());
	}

	@Test
	public void testGetGenre() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");
		assertEquals("Genre", song.getGenre());
	}

	@Test
	public void testGetAlbum() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");

		assertEquals("Album", song.getAlbum());
	}

	@Test
	public void testGetRank() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");

		assertEquals(0, song.getRank());
	}

	@Test
	public void testGetYear() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");
		assertEquals(0, song.getYear());

	}

	@Test
	public void testGetTag() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");

		assertEquals("Tag", song.getTag());

	}

	@Test
	public void testToString() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");

		assertEquals("Title", song.toString());
	}

	@Test
	public void testHashCode() {
		Song song = new Song("Title", "Artist", "Genre", "Album", 0, 0, "Tag");
		assertEquals(1972890172, song.hashCode());
	}
}
