package edu.westga.cs3211.playlist_generator;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

/** Contains entry point for the application, launches the landing page.
 * 
 * @author CS 3211
 * @version HW1
 */
public class Main extends Application {
    public static final String TITLE = "Playlist Generator";
    public static final String LANDING_PAGE_FXML = "view/LandingPage.fxml";
	public static final String ADD_PAGE = "view/AddPage.fxml";
	public static final String DISPLAY_PAGE = "view/DisplayPage.fxml";
	public static final String CONFIRMATION_DIALOG_FXML = "view/ConfirmationDialog.fxml";

    /**
     * JavaFX entry point.
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param primaryStage the main window hook
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(Main.LANDING_PAGE_FXML));
        loader.load();
        Scene scene = new Scene(loader.getRoot());
        primaryStage.setTitle(Main.TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Java entry point
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param args command line arguments <we don't really use these>
     */
    public static void main(String[] args) {
        Main.launch(args);
    }
}
