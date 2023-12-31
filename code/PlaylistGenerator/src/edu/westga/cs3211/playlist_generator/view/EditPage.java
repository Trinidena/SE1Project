package edu.westga.cs3211.playlist_generator.view;

import edu.westga.cs3211.playlist.resources.UI;
import edu.westga.cs3211.playlist_generator.Genre;
import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The page for editing songs
 * 
 * @author CS 3211
 * @version fall 2023
 * 
 */

public class EditPage {

	@FXML
	private TextField editAlbumTextField;

	@FXML
	private TextField editArtistTextField;

	@FXML
	private ComboBox<Genre> editGenreComboBox;

	@FXML
	private ComboBox<Integer> editRankComboBox;

	@FXML
	private TextField editTagTextField1;

	@FXML
	private TextField editTitleTextField;

	@FXML
	private TextField editYearTextField;

	@FXML
	private Label editErrorLabel;

	private ObservableList<Song> songs;

	private Song selectedSong;

	@FXML
	void cancel(ActionEvent event) {

		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	@FXML
	void editSongButton(ActionEvent event) {

		try {

			Song copySong = this.createCopySong();

			if (this.checkIfAdded(copySong)) {

				this.editErrorLabel.setText("Song already exists");
				this.editErrorLabel.setVisible(true);

			} else {
				this.setData();
				((Node) (event.getSource())).getScene().getWindow().hide();
			}

		} catch (IllegalArgumentException iae) {
			this.editErrorLabel.setText(iae.getLocalizedMessage());
			this.editErrorLabel.setVisible(true);
		} catch (NullPointerException npe) {
			this.editErrorLabel.setText(UI.EMPTY_GENRE);
			this.editErrorLabel.setVisible(true);
		}

	}

	/**
	 * Binds the data from the song object to the appropriate display fields.
	 * 
	 * @param songs is the list of Song objects to add
	 * 
	 * @return if the binding was successful
	 */
	public boolean bind(ObservableList<Song> songs) {
		if (songs == null) {
			return false;
		}
		this.songs = songs;
		return true;
	}

	/**
	 * sets the selected song
	 * 
	 * 
	 * @param song the song to set
	 */

	public void setSelectedSong(Song song) {
		this.selectedSong = song;
	}

	@FXML
	void initialize() {

		this.editErrorLabel.setVisible(false);

		if (this.selectedSong != null) {

			this.editTitleTextField.textProperty().set(this.selectedSong.getSongTitle());
			this.editArtistTextField.textProperty().set(this.selectedSong.getArtist());

			this.editAlbumTextField.textProperty().set(this.selectedSong.getAlbum());

			this.editYearTextField.textProperty().set(String.valueOf(this.selectedSong.getYear()));
			this.editTagTextField1.textProperty().set(this.selectedSong.getTag());

			this.populateGenreComboBox();
			this.populateRankComboBox();

		}

	}

	private void setData() {

		var rankCheck = this.editRankComboBox.getValue();

		this.selectedSong.setSongTitle(this.editTitleTextField.textProperty().get());
		this.selectedSong.setArtistName(this.editArtistTextField.textProperty().get());
		this.selectedSong.setGenre(this.editGenreComboBox.getValue().toString());
		this.selectedSong.setTag(this.editTagTextField1.textProperty().get());

		String yearString = this.editYearTextField.textProperty().get();

		int year = Integer.parseInt(this.editYearTextField.textProperty().get());

		if (rankCheck != null) {
			int rank = this.editRankComboBox.getValue();
			this.selectedSong.setRank(rank);
		}

		String album = this.editAlbumTextField.textProperty().get();

		if (album != null && !album.isEmpty()) {
			this.selectedSong.setAlbum(this.editAlbumTextField.textProperty().get());
		}
		if (yearString != null && !yearString.isEmpty()) {
			this.selectedSong.setYear(year);
		}

	}

	private boolean checkIfAdded(Song newSong) {

		for (Song currentSong : this.songs) {
			if (newSong.hashCode() == currentSong.hashCode()) {

				// note that songs that are identical except for tags are still considered
				// identical because tags are based on your own thoughts

				return true;
			}
		}

		return false;
	}

	private void populateGenreComboBox() {

		for (Genre currentGenre : Genre.values()) {
			this.editGenreComboBox.getItems().add(currentGenre);
		}
	}

	private void populateRankComboBox() {

		for (int rank = 1; rank < UI.RANK_LIMIT; rank++) {
			this.editRankComboBox.getItems().add(rank);
		}
	}

	private Song createCopySong() {
		var rankCheck = this.editRankComboBox.getValue();
		int rank = 0;

		String title = this.editTitleTextField.textProperty().get();
		String artist = this.editArtistTextField.textProperty().get();
		String genre = this.editGenreComboBox.getValue().toString();
		String tag = this.editAlbumTextField.getText();

		int year = Integer.parseInt(this.editYearTextField.textProperty().get());

		if (rankCheck != null) {
			rank = this.editRankComboBox.getValue();

		}

		String album = this.editAlbumTextField.textProperty().get();

		Song newSong = new Song(title, artist, genre, album, rank, year, tag);

		return newSong;
	}

}
