package edu.westga.cs3211.playlist_generator.view;

import java.util.List;

import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GeneratePlaylistPage {
	
	private ObservableList<Song> songs;
	
	private List<Song> generatedSongs;
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
    private TextField tagTextField1;

    @FXML
    private TextField yearTextField;

    @FXML
    void handleCancelButton(ActionEvent event) {
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void handleGenerateButton(ActionEvent event) {

    }

	public boolean bind(ObservableList<Song> songs) {
		if (songs == null) {
			return false;
		}
		this.songs = songs;
		return true;
	}
}
