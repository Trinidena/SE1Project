package edu.westga.cs3211.playlist_generator.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.westga.cs3211.playlist_generator.model.SeedInfo;

/**
 * Testing the seedinfo class
 * 
 * @author csuser
 * @version fall 2023
 */
public class TestSeed {

	@Test
	public void testGetters() {
		SeedInfo newInfo = new SeedInfo();

		newInfo.setSongTitle("Title");
		newInfo.setArtistName("Artist");
		newInfo.setGenre("Genre");
		newInfo.setRank(0);
		newInfo.setYear(0);
		newInfo.setTag("Tag");
		newInfo.setAlbum("Album");
		newInfo.setDesiredLength("zero");

		assertEquals("Title", newInfo.getSongTitle());
		assertEquals("Artist", newInfo.getArtist());
		assertEquals("Genre", newInfo.getGenre());
		assertEquals("Album", newInfo.getAlbum());
		assertEquals("Tag", newInfo.getTag());
		assertEquals(0, newInfo.getRank());
		assertEquals(0, newInfo.getYear());
	}

	@Test
	public void testToString() {
		SeedInfo newInfo = new SeedInfo();
		newInfo.setSongTitle("Title");
		assertEquals("Title", newInfo.toString());
	}
}
