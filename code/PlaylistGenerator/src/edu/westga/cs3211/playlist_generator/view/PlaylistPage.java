package edu.westga.cs3211.playlist_generator.view;

import java.util.ArrayList;
import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * Class displays the generated playlist from the GeneratePlaylistPage class
 * @author Trinidad
 * @version 1.0
 */
public class PlaylistPage {

	@FXML
	private ListView<Song> songs;
	
	/**
	 * method to be called from another controller for passing an arraylist of songs
	 * @param generatedSongs is the list of songs generated for the playlist
	 */
	public void bind(ArrayList<Song> generatedSongs) {
		for (Song currentSong : generatedSongs) {
			this.songs.getItems().add(currentSong);
		}

	}

}
