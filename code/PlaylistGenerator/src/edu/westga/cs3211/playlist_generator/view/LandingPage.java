package edu.westga.cs3211.playlist_generator.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import edu.westga.cs3211.playlist_generator.Main;
import edu.westga.cs3211.playlist_generator.model.Song;

/**
 * Code behind for the Landing Page.
 * 
 * @author CS 3211
 * @version HW1
 */
public class LandingPage {
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private ListView<Song> songs;
	@FXML
	private TextArea songDetailsTextArea;
	@FXML
	private Button generateButton;

	@FXML
	void handleRemoveSongButton(ActionEvent event) throws IOException {

		if (this.songs.getItems().size() > 0) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.CONFIRMATION_DIALOG_FXML));
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage addTodoStage = new Stage();
			addTodoStage.setTitle(Main.TITLE);
			addTodoStage.setScene(scene);
			addTodoStage.initModality(Modality.APPLICATION_MODAL);
			ConfirmationDialog confirmationDialog = loader.getController();
			confirmationDialog.bind(this.songs.getItems(), this.songs.getSelectionModel().getSelectedItem());
			this.songDetailsTextArea.clear();
			addTodoStage.show();
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
	void handleGenerateButton(ActionEvent event) throws IOException {

		if (this.songs.getItems().size() > 0) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.GENERATE_PLAYLIST_PAGE_FXML));
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage addTodoStage = new Stage();
			addTodoStage.setTitle(Main.TITLE);
			addTodoStage.setScene(scene);
			addTodoStage.initModality(Modality.APPLICATION_MODAL);
			GeneratePlaylistPage page = loader.getController();
			page.bind(this.songs.getItems());

			addTodoStage.show();
		}

	}

	// @FXML
	// void displaySong(MouseEvent event) throws IOException {
	// final Song selectedItem = this.songs.getSelectionModel().getSelectedItem();
	// if (selectedItem != null) {
	// FXMLLoader loader = new FXMLLoader();
	// loader.setLocation(Main.class.getResource(Main.DISPLAY_PAGE));
	// loader.load();
	// Parent parent = loader.getRoot();
	// Scene scene = new Scene(parent);
	// Stage addTodoStage = new Stage();
	// addTodoStage.setTitle(Main.TITLE);
	// addTodoStage.setScene(scene);
	// addTodoStage.initModality(Modality.APPLICATION_MODAL);
	// DisplayPage displayPage = loader.getController();
	// displayPage.bind(selectedItem);
	// addTodoStage.show();
	// }
	// }

	@FXML
	void displaySongDetails(MouseEvent event) throws IOException {
		if (this.songs.getItems().size() > 0) {
			final Song selectedSong = this.songs.getSelectionModel().getSelectedItem();
			this.songDetailsTextArea.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
			this.songDetailsTextArea.setText(this.formatSongDetails(selectedSong));
		}

	}

	/**
	 * Formats the details to be displayed
	 * 
	 * 
	 * @param selectedSong the selected song
	 * @return the formatted song details
	 */
	public String formatSongDetails(Song selectedSong) {

		String formattedSongDetails = "";
		formattedSongDetails = formattedSongDetails.concat("Song: ").concat(selectedSong.getSongTitle()).concat("\n")
				.concat("Artist: ").concat(selectedSong.getArtist()).concat("\n").concat("Genre: ")
				.concat(selectedSong.getGenre()).concat("\n").concat("Album: ").concat(selectedSong.getAlbum())
				.concat("\n").concat("Rank: ").concat(Integer.toString(selectedSong.getRank())).concat("\n")
				.concat("Year: ").concat(Integer.toString(selectedSong.getYear())).concat("\n").concat("Tag: ")
				.concat(String.join(", ", selectedSong.getTags()));

		return formattedSongDetails;
	}

	@FXML
	void editButton(ActionEvent event) throws IOException {

		final Song selectedSong = this.songs.getSelectionModel().getSelectedItem();

		if (this.songs.getItems().size() > 0 && selectedSong != null) {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.EDIT_PAGE));
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage addTodoStage = new Stage();
			addTodoStage.setTitle(Main.TITLE);
			addTodoStage.setScene(scene);
			addTodoStage.initModality(Modality.APPLICATION_MODAL);
			EditPage editPage = loader.getController();

			editPage.setSelectedSong(selectedSong);

			editPage.initialize();
			editPage.bind(this.songs.getItems());

			addTodoStage.showAndWait();
			this.songs.refresh();
			this.displaySongDetails(null);
		}

	}

	@FXML
	void initialize() {
		this.songs.setStyle("-fx-font-size: 1.5em;");
		this.songs.setStyle("-fx-font: normal bold 20 'Verdana'");
		this.songDetailsTextArea.setEditable(false);
	}
}