package edu.westga.cs3211.playlist_generator.view;

import java.util.ArrayList;

import edu.westga.cs3211.playlist_generator.model.SeedInfo;
import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GeneratePlaylistPage {

	private ObservableList<Song> songs;

	private ArrayList<Song> generatedSongs;

	private ArrayList<String> generatedTags;

	private SeedInfo seedInfo;
	@FXML
	private TextField albumTextField;

	@FXML
	private TextField artistTextField;

	@FXML
	private Button cancelButton;

	@FXML
	private Button generateButton;

	@FXML
	private TextField genreTextField;

	@FXML
	private TextField rankTextField;

	@FXML
	private TextField songTitleTextField;

	@FXML
	private TextField tagTextField;

	@FXML
	private TextField yearTextField;

	@FXML
	private TextField lengthTextField;

	@FXML
	void handleCancelButton(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void handleGenerateButton(ActionEvent event) {
		this.gatherSeedInfo();
		this.generatePlaylist();
	}

	private void gatherSeedInfo() {
		if (this.artistTextField != null) {
			this.seedInfo.setArtistName(this.artistTextField.getText());
		}
		if (this.songTitleTextField != null) {
			this.seedInfo.setSongTitle(this.songTitleTextField.getText());
		}
		if (this.genreTextField != null) {
			this.seedInfo.setGenre(this.genreTextField.getText());
		}
		if (this.tagTextField != null) {
			this.seedInfo.setTag(new ArrayList<String>());
		}
		if (this.lengthTextField != null) {
			this.seedInfo.setDesiredLength(this.lengthTextField.getText());
		}
	}

	private void generatePlaylist() {
		for (Song song : this.songs) {
			if (song.getArtist().equals(this.seedInfo.getArtist())) {
				this.generatedSongs.add(song);
			}
			if (song.getSongTitle().equals(this.seedInfo.getSongTitle())) {
				this.generatedSongs.add(song);
			}
			if (song.getGenre().equals(this.seedInfo.getGenre())) {
				this.generatedSongs.add(song);
			}

			for (String seedTag : this.seedInfo.getTag()) {
				if (song.getTag().contains(seedTag)) {

				}
			}
		}

	}

	/**
	 * Binds the list to an outside list
	 * 
	 * @param songs the list to bind
	 * @return true if successfully binded
	 */

	public boolean bind(ObservableList<Song> songs) {
		if (songs == null) {
			return false;
		}
		this.songs = songs;
		return true;
	}

	void initialize() {
		this.seedInfo = new SeedInfo();
		this.generatedSongs = new ArrayList<Song>();
	}
}
