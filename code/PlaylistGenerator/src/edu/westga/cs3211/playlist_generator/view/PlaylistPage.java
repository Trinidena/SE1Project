package edu.westga.cs3211.playlist_generator.view;

import java.util.ArrayList;
import java.util.Collection;

import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PlaylistPage {

	@FXML
	private ListView<Song> songs;

	public void bind(ArrayList<Song> generatedSongs) {
		for (Song currentSong : generatedSongs) {
			this.songs.getItems().add(currentSong);
		}

	}

}
