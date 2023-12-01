package edu.westga.cs3211.playlist_generator.view;

import java.io.IOException;
import java.util.ArrayList;

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
	void handleGenerateButton(ActionEvent event) throws IOException {
		this.gatherSeedInfo();
		this.generatePlaylist();
		this.loadPlaylistPage();
	}

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
		page.bind(this.songs);
		addTodoStage.show();
	}

	public void gatherSeedInfo() {
		if (this.artistTextField != null) {
			this.seedInfo.setArtistName(this.artistTextField.getText());
		}
		if (this.songTitleTextField != null) {
			this.seedInfo.setSongTitle(this.songTitleTextField.getText());
		}
		if (this.genreTextField != null) {
			this.seedInfo.setGenre(this.genreTextField.getText());
		}
		if (this.tagTextField != null) {
			this.seedInfo.setTag(new ArrayList<String>());
		}
		if (this.lengthTextField != null) {
			this.seedInfo.setDesiredLength(this.lengthTextField.getText());
		}
	}

	public void generatePlaylist() {

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
			for (String seedTag : this.seedInfo.getTag()) {
				if (song.getTags().contains(seedTag)) {
					this.generatedSongs.add(song);
				}
			}
		}
		checkForDuplicateSongs();
		while (Integer.parseInt(this.lengthTextField.getText()) > this.generatedSongs.size()) {
			if (!generatedSongs.isEmpty()) {
			    generatedSongs.remove(generatedSongs.size() - 1);
			}
		}
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
		for (int i = 0; i < this.generatedSongs.size(); i++) {
            Song currentSong = this.generatedSongs.get(i);
            for (int j = i + 1; j < this.generatedSongs.size(); j++) {
                Song nextSong = this.generatedSongs.get(j);
                if (currentSong.equals(nextSong)) {
                	this.generatedSongs.remove(j);
                    j--;
                }
            }
        }
	}
	void initialize() {
		this.seedInfo = new SeedInfo();
		this.generatedSongs = new ArrayList<Song>();
		FXCollections.shuffle(this.songs);
	}
}
