package edu.westga.cs3211.playlist_generator.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import edu.westga.cs3211.playlist_generator.Genre;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Class generates the playlist page where the generated playlist is shown
 * 
 * @author Trinidad
 * @version 1.0
 */

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
	private ComboBox<Genre> generateComboBox;

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

	@FXML
	void handleGenerateButton(ActionEvent event) throws IOException {
		this.gatherSeedInfo();
		if (!this.allFieldsAreEmpty) {
			this.generatePlaylist();
		}
		this.loadPlaylistPage();
	}

	/**
	 * method loads the page the contains the generated playlist
	 * 
	 * @throws IOException
	 */
	public void loadPlaylistPage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.PLAYLIST_PAGE_FXML));
		loader.load();
		Parent parent = loader.getRoot();
		Scene scene = new Scene(parent);
		Stage addTodoStage = new Stage();
		addTodoStage.setTitle(Main.TITLE);
		addTodoStage.setScene(scene);
		addTodoStage.initModality(Modality.APPLICATION_MODAL);
		PlaylistPage page = loader.getController();
		page.bind(this.generatedSongs);
		addTodoStage.show();
	}

	/**
	 * method gathers the seed info provided from the user to be used in generation
	 */
	public void gatherSeedInfo() {
		this.checkAllFieldsEmpty();

		if (!this.allFieldsAreEmpty) {
			if (this.artistTextField != null) {
				this.seedInfo.setArtistName(this.artistTextField.getText());
			}
			if (this.songTitleTextField != null) {
				this.seedInfo.setSongTitle(this.songTitleTextField.getText());
			}
			if (this.generateComboBox.getValue().toString() != null) {
				this.seedInfo.setGenre(this.generateComboBox.getValue().toString());
			}
			if (this.tagTextField != null) {
				this.seedInfo.setTag(this.tagTextField.getText());
			}
			if (this.lengthTextField != null) {
				this.seedInfo.setDesiredLength(this.lengthTextField.getText());
			}
		} else {
			this.generatePlaylist(true);
		}
	}

	private void checkAllFieldsEmpty() {
		if (this.artistTextField.getText() == null
				|| this.artistTextField.getText().trim().isEmpty() && this.songTitleTextField.getText() == null
				|| this.songTitleTextField.getText().trim().isEmpty()
						&& this.generateComboBox.getValue().toString() == null
				|| this.generateComboBox.getValue().toString().trim().isEmpty() && this.tagTextField.getText() == null
				|| this.tagTextField.getText().trim().isEmpty() && this.lengthTextField.getText() == null
				|| this.lengthTextField.getText().trim().isEmpty()) {
			this.allFieldsAreEmpty = true;
		}
	}

	/**
	 * method generates the playlist if none of the fields are empty
	 */
	public void generatePlaylist() {
		while (this.generatedSongs.size() <= (Integer.parseInt(this.lengthTextField.getText()))) {
			FXCollections.shuffle(this.songs);
			for (Song song : this.songs) {
				if (song.getArtist().equals(this.seedInfo.getArtist())) {
					this.generatedSongs.add(song);
				}
				if (song.getSongTitle().equals(this.seedInfo.getSongTitle())) {
					this.generatedSongs.add(song);
				}
				if (song.getGenre().equals(this.seedInfo.getGenre())) {
					this.generatedSongs.add(song);
				}
				// for (String seedTag : this.seedInfo.getTag()) {
				if (song.getTag().equals(this.seedInfo.getTag())) {
					this.generatedSongs.add(song);
				}
			}
		}
		this.checkForDuplicateSongs();
		while (Integer.parseInt(this.lengthTextField.getText()) > this.generatedSongs.size()) {
			if (!this.generatedSongs.isEmpty()) {
				this.generatedSongs.remove(this.generatedSongs.size() - 1);
			}
		}
	}

	/**
	 * generates the playlist based on if all the fields are empty on the page
	 * 
	 * @param allFieldsAreEmpty is a boolean that is set when CheckAllFieldsEmpty()
	 *                          is called
	 */
	public void generatePlaylist(boolean allFieldsAreEmpty) {
		FXCollections.shuffle(this.songs);
		Random random = new Random();
		int count = 0;
		this.randomTargetLength = random.nextInt((PLAYLIST_MAX - PLAYLIST_MIN) + PLAYLIST_MIN);
		while (count < this.randomTargetLength) {
			for (Song song : this.songs) {
				this.generatedSongs.add(song);
				count++;
			}
		}
		this.checkForDuplicateSongs();
	}

	/**
	 * Binds the list to an outside list
	 * 
	 * @param songs the list to bind
	 * @return true if successfully binded
	 */

	public boolean bind(ObservableList<Song> songs) {
		if (songs == null) {
			return false;
		}
		this.songs = songs;
		return true;
	}

	private void checkForDuplicateSongs() {
		for (int index = 0; index < this.generatedSongs.size(); index++) {
			Song currentSong = this.generatedSongs.get(index);
			for (int index2 = index + 1; index2 < this.generatedSongs.size(); index2++) {
				Song nextSong = this.generatedSongs.get(index2);
				if (currentSong.equals(nextSong)) {
					this.generatedSongs.remove(index2);
					index2--;
				}
			}
		}
	}

	@FXML
	void initialize() {
		this.seedInfo = new SeedInfo();
		this.generatedSongs = new ArrayList<Song>();
		this.populateGenreComboBox();
	}

	private void populateGenreComboBox() {

		for (Genre currentGenre : Genre.values()) {
			this.generateComboBox.getItems().add(currentGenre);
		}
	}
}
