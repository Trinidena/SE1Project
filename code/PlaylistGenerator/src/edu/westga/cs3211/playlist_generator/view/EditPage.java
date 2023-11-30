package edu.westga.cs3211.playlist_generator.view;

import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class EditPage {

	@FXML
	private TextField editAlbumTextField;

	@FXML
	private TextField editArtistTextField;

	@FXML
	private TextField editGenreTextField;

	@FXML
	private TextField editRankTextField;

	@FXML
	private TextField editTagTextField1;

	@FXML
	private TextField editTitleTextField;

	@FXML
	private TextField editYearTextField;

	private ObservableList<Song> songs;

	private Song selectedSong;

	@FXML
	void cancel(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	@FXML
	void editSongButton(ActionEvent event) {

		this.setData();

		((Node) (event.getSource())).getScene().getWindow().hide();
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

	@FXML
	void initialize() {
		if (selectedSong != null) {
			this.editTitleTextField.textProperty().set(this.selectedSong.getSongTitle());
			this.editArtistTextField.textProperty().set(this.selectedSong.getArtist());
			this.editGenreTextField.textProperty().set(this.selectedSong.getGenre());
			this.editAlbumTextField.textProperty().set(this.selectedSong.getAlbum());
			this.editRankTextField.textProperty().set(String.valueOf(this.selectedSong.getRank()));
			this.editYearTextField.textProperty().set(String.valueOf(this.selectedSong.getYear()));

		}

	}

	public void setSelectedSong(Song newSong) {

		this.selectedSong = newSong;

	}

	private void setData() {
		this.selectedSong.setSongTitle(this.editTitleTextField.textProperty().get());
		this.selectedSong.setArtistName(this.editArtistTextField.textProperty().get());
		this.selectedSong.setGenre(this.editGenreTextField.textProperty().get());

		String yearString = this.editYearTextField.textProperty().get();
		String rankString = this.editRankTextField.textProperty().get();

		int year = Integer.parseInt(this.editYearTextField.textProperty().get());
		int rank = Integer.parseInt(rankString);

		String album = this.editAlbumTextField.textProperty().get();

		if (album != null && !album.isEmpty()) {
			this.selectedSong.setAlbum(this.editAlbumTextField.textProperty().get());
		}
		if (yearString != null && !yearString.isEmpty()) {
			this.selectedSong.setYear(year);
		}
		if (rankString != null && !rankString.isEmpty()) {
			this.selectedSong.setRank(rank);
		}
	}

}
