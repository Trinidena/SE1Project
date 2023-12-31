package edu.westga.cs3211.playlist_generator.view;

import java.net.URL;

import java.util.ResourceBundle;

import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import edu.westga.cs3211.playlist.resources.UI;
import edu.westga.cs3211.playlist_generator.Genre;

/**
 * Code behind for the Add Page.
 * 
 * @author CS 3211
 * @version HW1
 */
public class AddPage {
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;

	@FXML
	private TextField songTitleTextField;
	@FXML
	private TextField artistTextField;
	@FXML
	private ComboBox<Genre> addGenreComboBox;
	@FXML
	private ComboBox<Integer> addRankComboBox;
	@FXML
	private TextField tagTextField;
	@FXML
	private TextField albumTextField;

	@FXML
	private TextField yearTextField;

	@FXML
	private Label addErrorLabel;

	private ObservableList<Song> songs;

	private Song addedSong;

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
	void addSongButton(ActionEvent event) {

		try {

			int rank = 0;

			var rankCheck = this.addRankComboBox.getValue();
			if (rankCheck != null) {
				rank = this.addRankComboBox.getValue();

			}

			String comboString = this.addGenreComboBox.getValue().toString();

			Song song = new Song(this.songTitleTextField.getText(), this.artistTextField.getText(), comboString,
					this.albumTextField.getText(), rank, Integer.parseInt(this.yearTextField.getText()),
					this.tagTextField.getText());

			this.addedSong = song;

			if (!this.checkIfAdded()) {
				this.songs.add(song);
				((Node) (event.getSource())).getScene().getWindow().hide();
			} else {
				this.addErrorLabel.setText("Song already exists");
				this.addErrorLabel.setVisible(true);

			}

		} catch (

		IllegalArgumentException iae) {
			this.addErrorLabel.setText(iae.getLocalizedMessage());
			this.addErrorLabel.setVisible(true);
		} catch (NullPointerException npe) {
			this.addErrorLabel.setText(UI.EMPTY_GENRE);
			this.addErrorLabel.setVisible(true);
		}

	}

	@FXML
	void cancel(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	@FXML
	void initialize() {
		this.addErrorLabel.setVisible(false);
		this.yearTextField.textProperty().set("0");
		this.populateGenreComboBox();
		this.populateRankComboBox();
	}

	private boolean checkIfAdded() {
		for (Song currentSong : this.songs) {
			if (this.addedSong.hashCode() == currentSong.hashCode()) {
				// note that songs that are identical except for tags are still considered
				// identical because tags are based on your own thoughts
				return true;
			}
		}
		return false;
	}

	private void populateGenreComboBox() {

		for (Genre currentGenre : Genre.values()) {
			this.addGenreComboBox.getItems().add(currentGenre);
		}
	}

	private void populateRankComboBox() {

		for (int rank = 1; rank < UI.RANK_LIMIT; rank++) {
			this.addRankComboBox.getItems().add(rank);
		}
	}
}