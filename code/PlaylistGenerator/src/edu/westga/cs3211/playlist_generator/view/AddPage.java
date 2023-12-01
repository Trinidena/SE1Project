package edu.westga.cs3211.playlist_generator.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

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
	private TextField genreTextField;
	@FXML
	private TextField tagTextField;
	@FXML
	private TextField albumTextField;

	@FXML
	private TextField rankTextField;

	@FXML
	private TextField yearTextField;

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
		Song song = new Song(this.songTitleTextField.getText(),
			 this.artistTextField.getText(), this.genreTextField.getText(), 
			 this.albumTextField.getText(), Integer.parseInt(this.rankTextField.getText()),
			 Integer.parseInt(this.yearTextField.getText()), this.tagTextField.getText());
	
		this.songs.add(song);
		
		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	@FXML
	void cancel(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	@FXML
	void initialize() {
	}

	private void setOptionalItems() {
		String albumName = this.albumTextField.textProperty().get();

		if (!albumName.isEmpty()) {
			this.addedSong.setAlbum(albumName);
		}

	}
}