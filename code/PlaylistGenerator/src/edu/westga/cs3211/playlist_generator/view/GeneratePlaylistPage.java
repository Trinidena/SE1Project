package edu.westga.cs3211.playlist_generator.view;

import java.util.ArrayList;
import java.util.List;

import edu.westga.cs3211.playlist_generator.model.SeedInfo;
import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GeneratePlaylistPage {
	
	private ObservableList<Song> songs;
	
	private ArrayList<Song> generatedSongs;
	
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
    	gatherSeedInfo();
    	generatePlaylist();
    }

	private void gatherSeedInfo() {
		if (this.artistTextField != null) {
			this.seedInfo.setArtistName(this.artistTextField.getText());
		}if (this.songTitleTextField != null) {
			this.seedInfo.setSongTitle(this.songTitleTextField.getText());
		}if (this.genreTextField != null) {
			this.seedInfo.setGenre(this.genreTextField.getText());
		}if (this.tagTextField != null) {
			this.seedInfo.setTag(new ArrayList<String>());
		}if (this.lengthTextField != null) {
			this.seedInfo.setDesiredLength(this.lengthTextField.getText());
		}
	}
	
	private void generatePlaylist() {
		for(Song song : songs) {
			if (song.getArtist().equals(seedInfo.getArtist())) {
				generatedSongs.add(song);
			}
			if (song.getSongTitle().equals(seedInfo.getSongTitle())) {
				generatedSongs.add(song);
			}
			if (song.getGenre().equals(seedInfo.getGenre())) {
				generatedSongs.add(song);
			}
			
			for (String seedTag : seedInfo.getTag()) {
			    if (song.getTag().contains(seedTag)) {
			        generatedSongs.add(song);
			    }
			}
		}
		
	}

	public boolean bind(ObservableList<Song> songs) {
		if (songs == null) {
			return false;
		}
		this.songs = songs;
		return true;
	}
	
	void initialize() {
		seedInfo = new SeedInfo();
		generatedSongs = new ArrayList<Song>();
		FXCollections.shuffle(songs);
	}
}
