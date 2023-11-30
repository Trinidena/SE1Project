package edu.westga.cs3211.playlist_generator.model;

/** Stores and manages information for a single Prescription.
 * 
 * @author CS 3211
 * @version HW1
 */
public class Song {
	private String songTitle;
	private String artist;
	private String genre;
	private String album;
	private String rank;
	private String year;
	private String tag;
	
	/** Create a new song with the provided information.
	 * 
	 * @param songTitle is the title of the song
	 * @param artist is the owner of the song
	 * @param genre is the category of the song
	 */
	public Song(String songTitle, String artist, String genre) {
			if(songTitle == null || artist == null || genre == null) {
				throw new IllegalArgumentException();
		}
		this.songTitle = songTitle;
		this.artist = artist;
		this.genre = genre;
	}
	
	/** name of song
	 * @return the name
	 */
	public String getSongTitle() {
		return this.songTitle;
	}

	/** artist for the song
	 * @return the artist
	 */
	public String getArtist() {
		return this.artist;
	}

	/** genre for the song
	 * @return the refill
	 */
	public String getGenre() {
		return this.genre;
	}

	/** album for the song
	 * @return the album
	 */
	public String getAlbum() {
		return this.album;
	}

	/** rank of the song
	 * @return the rank
	 */
	public String getRank() {
		return this.rank;
	}

	/** year for the song
	 * @return the year
	 */
	public String getYear() {
		return this.year;
	}

	/** Convert object to a String representation.
	 *  @return String representation of the Song object
	 */
	@Override
	public String toString() {
		return this.songTitle;
	}

	public String getTag() {
		return tag;
	}
}
