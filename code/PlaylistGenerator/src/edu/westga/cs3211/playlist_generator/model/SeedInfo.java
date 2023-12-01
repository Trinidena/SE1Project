package edu.westga.cs3211.playlist_generator.model;

/**
 * class provides a model for storing the seed info provided by the user
 * @author Trinidad
 * @version 1.0
 */

public class SeedInfo {

	private String songTitle;
	private String artist;
	private String genre;
	private String album;
	private int rank;
	private int year;
	private String tag;

	/**
	 * gets the title of the song
	 * 
	 * @return the title of the song
	 */

	public String getSongTitle() {
		return this.songTitle;
	}

	/**
	 * Sets the song title
	 * 
	 * @param newTitle the title to set
	 */

	public void setSongTitle(String newTitle) {
		this.songTitle = newTitle;
	}

	/**
	 * artist for the song
	 * 
	 * @return the artist
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Sets the artist name
	 * 
	 * @param newArtist the artist name to set
	 */

	public void setArtistName(String newArtist) {
		this.artist = newArtist;
	}

	/**
	 * genre for the song
	 * 
	 * @return the refill
	 */
	public String getGenre() {
		return this.genre;
	}

	/**
	 * Sets the genre
	 * 
	 * @param newGenre the genre to set
	 */

	public void setGenre(String newGenre) {
		this.genre = newGenre;
	}

	/**
	 * album for the song
	 * 
	 * @return the album
	 */
	public String getAlbum() {
		return this.album;
	}

	/**
	 * Sets the Album name
	 * 
	 * @param newAlbum the album name to set
	 */

	public void setAlbum(String newAlbum) {
		this.album = newAlbum;
	}

	/**
	 * rank of the song
	 * 
	 * @return the rank
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * Sets the rank
	 * 
	 * @param newRank the rank to set
	 */

	public void setRank(int newRank) {
		this.rank = newRank;
	}

	/**
	 * year for the song
	 * 
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Sets the year
	 * 
	 * @param newYear the year to set
	 */

	public void setYear(int newYear) {
		this.year = newYear;
	}

	/**
	 * Convert object to a String representation.
	 * 
	 * @return String representation of the Song object
	 */
	@Override
	public String toString() {
		return this.songTitle;
	}

	/**
	 * Gets a list of tags
	 * 
	 * @return the list of tags
	 */

	public String getTag() {
		return this.tag;
	}

	/**
	 * Sets the tag
	 * 
	 * @param tag the tag to set
	 */

	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * Sets the desired length
	 * 
	 * @param length the length desired
	 */

	public void setDesiredLength(String length) {
	}
}
