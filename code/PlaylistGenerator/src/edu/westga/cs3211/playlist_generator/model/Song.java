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
	
	/** name of the RX
	 * @return the name
	 */
	public String getSongTitle() {
		return this.songTitle;
	}

	/** dosage amount for the RX
	 * @return the dosage
	 */
	public String getArtist() {
		return this.artist;
	}

	/** number of refills remaining for the RX
	 * @return the refill
	 */
	public String getGenre() {
		return this.genre;
	}

	/** number of doses remaining for the RX
	 * @return the doses
	 */
	public String getAlbum() {
		return this.album;
	}

	/** purpose of the RX (i.e., why am I taking this medication?)
	 * @return the purpose
	 */
	public String getRank() {
		return this.rank;
	}

	/** any known side effects for the RX
	 * @return the effects
	 */
	public String getYear() {
		return this.year;
	}

	/** Convert object to a String representation.
	 *  @return String representation of the RX object
	 */
	@Override
	public String toString() {
		return this.songTitle + " " + this.artist + " " + genre;
	}

	public String getTag() {
		return tag;
	}
}
