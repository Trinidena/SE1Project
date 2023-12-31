package edu.westga.cs3211.playlist_generator.model;

import java.time.LocalDate;

import java.util.Objects;

import edu.westga.cs3211.playlist.resources.UI;

/**
 * Stores and manages information for a single Prescription.
 * 
 * @author CS 3211
 * @version HW1
 */
public class Song {
	private static final int CUTOFF_YEAR = 999;
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
	 * @param album     the album the song comes from
	 * @param rank      the rank of the song
	 * @param tag       the tag
	 * @param year      the year the song came out
	 */

	public Song(String songTitle, String artist, String genre, String album, int rank, int year, String tag) {

		this.setSongTitle(songTitle);
		this.setArtistName(artist);

		this.setGenre(genre);

		this.setYear(year);

		this.setAlbum(album);
		this.setRank(rank);

		this.setTag(tag);

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
	 * @param newTitle the title to set
	 */

	public void setSongTitle(String newTitle) {

		if (newTitle == null) {
			throw new IllegalArgumentException(UI.EMPTY_TITLE);
		}

		if (newTitle.isBlank()) {
			throw new IllegalArgumentException(UI.EMPTY_TITLE);
		}

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
		if (newArtist == null) {
			throw new IllegalArgumentException(UI.EMPTY_ARTIST);
		}

		if (newArtist.isBlank()) {
			throw new IllegalArgumentException(UI.EMPTY_ARTIST);
		}

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
		if (newGenre == null) {
			throw new IllegalArgumentException(UI.EMPTY_ALBUM);
		}

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
	 * @param newAlbum the album name ti set
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
		if (newYear > LocalDate.now().getYear() || newYear < CUTOFF_YEAR && newYear != 0) {
			throw new IllegalArgumentException(UI.INVALID_YEAR);
		}

		this.year = newYear;
	}

	/**
	 * Sets the list of tags
	 * 
	 * 
	 * @param tags the list to be set
	 */
	public void setTag(String tags) {
		this.tag = tags;
	}

	/**
	 * gets the list of tags
	 * 
	 * @return the list of tags
	 */
	public String getTag() {
		return this.tag;

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

	@Override
	public int hashCode() {
		return Objects.hash(this.songTitle, this.artist, this.genre, this.album, this.rank, this.year);
	}

}