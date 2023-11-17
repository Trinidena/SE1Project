package edu.westga.cs3211.playlist_generator.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import edu.westga.cs3211.playlist_generator.Main;
import edu.westga.cs3211.playlist_generator.model.Song;

/** Code behind for the Landing Page.
 * 
 * @author CS 3211
 * @version HW1
 */
public class LandingPage {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private ListView<Song> songs;

    @FXML
    void removeSong(ActionEvent event) {
    	final Song selectedItem = this.songs.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
    		this.songs.getItems().remove(selectedItem);
    	}
    }
    
    @FXML
    void addSongButton(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.ADD_PAGE));
    	loader.load();
    	Parent parent = loader.getRoot();
    	Scene scene = new Scene(parent);
    	Stage addTodoStage = new Stage();
    	addTodoStage.setTitle(Main.TITLE);
    	addTodoStage.setScene(scene);
    	addTodoStage.initModality(Modality.APPLICATION_MODAL);
    	AddPage addPage = loader.getController();
    	addPage.bind(this.songs.getItems());
    	
    	addTodoStage.show();

    }

    @FXML
    void displaySong(MouseEvent event) throws IOException {
    	final Song selectedItem = this.songs.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(Main.class.getResource(Main.DISPLAY_PAGE));
	    	loader.load();
	    	Parent parent = loader.getRoot();
	    	Scene scene = new Scene(parent);
	    	Stage addTodoStage = new Stage();
	    	addTodoStage.setTitle(Main.TITLE);
	    	addTodoStage.setScene(scene);
	    	addTodoStage.initModality(Modality.APPLICATION_MODAL);
	    	DisplayPage displayPage = loader.getController();
	    	displayPage.bind(selectedItem);
	    	addTodoStage.show();
    	}
    }
    
    @FXML
    void editButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
    }
}
