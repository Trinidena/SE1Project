package edu.westga.cs3211.song_manager.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/** Code behind for the Display Page.
 * 
 * @author CS 3211
 * @version HW1
 */
public class DisplayPage {
	@FXML private ResourceBundle resources;
	@FXML private URL location;
	@FXML private TextField songTitleTextField;
	@FXML private TextField artistTextField;
	@FXML private TextField genreTextField;
    
    /** Binds the data from the song object to the appropriate display fields.
     * 
     * @param song the song object with data to display
     * 
     * @return if the binding was successful
     */
    public boolean bind(Song song) {
    	if (song == null) {
    		return false;
    	}
    	
    	this.songTitleTextField.setText(song.getSongTitle());
    	this.genreTextField.setText(song.getGenre() + "");
    	this.artistTextField.setText(song.getArtist() + "");
    	return true;
    }

    @FXML
    void initialize() {
    }
}
