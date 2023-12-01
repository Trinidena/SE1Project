package edu.westga.cs3211.playlist_generator.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import edu.westga.cs3211.playlist_generator.Main;
import edu.westga.cs3211.playlist_generator.model.SeedInfo;
import edu.westga.cs3211.playlist_generator.model.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GeneratePlaylistPage {

	private static final int PLAYLIST_MAX = 15;
	private static final int PLAYLIST_MIN = 10;

	private ObservableList<Song> songs;

	private ArrayList<Song> generatedSongs;

	private SeedInfo seedInfo;

	private int randomTargetLength;
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

	private boolean allFieldsAreEmpty;

	@FXML
	void handleCancelButton(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

}
