package edu.westga.cs3211.playlist_generator.model;

/**
 * Stores and manages information for a single Prescription.
 * 
 * @author CS 3211
 * @version HW1
 */
public class Song {
	private String songTitle;
	private String artist;
	private String genre;
	private String album;
	private int rank;
	private int year;
	private String tag;

	/**
	 * Create a new song with the provided information.
	 * 
	 * @param songTitle is the title of the song
	 * @param artist    is the owner of the song
	 * @param genre     is the category of the song
	 */
	public Song(String songTitle, String artist, String genre, String tag) {
		if (songTitle == null || artist == null || genre == null) {
			throw new IllegalArgumentException();
		}
		this.songTitle = songTitle;
		this.artist = artist;
		this.genre = genre;
		this.tag = tag;
	}

	/**
	 * name of song
	 * 
	 * @return the name
	 */
	public String getSongTitle() {
		return this.songTitle;
	}

	/**
	 * Sets the song title
	 * 
	 * @param newTitle
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
	 * @param newArtist
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
	 * @param newGenre
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
	 * @param newAlbum
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
	 * @param newRank
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
	 * @param newYear
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
		return this.songTitle + "		" + this.tag;
	}

	public String getTag() {
		return tag;
	}
}
