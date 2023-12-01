package edu.westga.cs3211.playlist_generator.view;

import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class PlaylistPage {

	@FXML
	private ListView<Song> songs;

	public void bind(ObservableList<Song> items) {
		// TODO Auto-generated method stub

	}

}
