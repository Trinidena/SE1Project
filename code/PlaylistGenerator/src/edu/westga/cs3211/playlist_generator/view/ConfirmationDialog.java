package edu.westga.cs3211.playlist_generator.view;

import java.io.IOException;

import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ConfirmationDialog {

	private Song selectedSong;
    @FXML
    private Button noButton;

    @FXML
    private Button yesButton;

    private ObservableList<Song> songs;
    
    @FXML
    void handleNoButton(ActionEvent event) {
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void handleYesButton(ActionEvent event) throws IOException {
    	this.songs.remove(selectedSong);
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    public boolean bind(ObservableList<Song> songs, Song song) {
		if (songs == null) {
			return false;
		}
		this.songs = songs;
		this.selectedSong = song;
		return true;
	}

    @FXML
    void initialize() {
    }

}
