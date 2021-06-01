package favoliere;

import favoliere.controller.Controller;
import favoliere.controller.MyController;
import favoliere.persistence.AzioniLoader;
import favoliere.persistence.ConclusioniLoader;
import favoliere.persistence.PersonaggiLoader;
import favoliere.persistence.ScenariLoader;
import favoliere.ui.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FavoliereApp extends Application {

	public final String FILENAME_PERSONAGGI  = "Personaggi.txt";
	public final String FILENAME_SCENARI 	 = "Scenari.txt";
	public final String FILENAME_AZIONI 	 = "Azioni.txt";
	public final String FILENAME_CONCLUSIONI = "Conclusioni.txt";
	public final String OUTPUT_FILE_NAME	 = "Favola.txt";
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Il Favoliere");
		
		Controller controller = new MyController(new PersonaggiLoader(), FILENAME_PERSONAGGI, new ScenariLoader(), FILENAME_SCENARI,
				new AzioniLoader(), FILENAME_AZIONI, new ConclusioniLoader(), FILENAME_CONCLUSIONI,OUTPUT_FILE_NAME);
		
		MainPane mainPanel = new MainPane(controller);

		Scene scene = new Scene(mainPanel, 600, 400, Color.YELLOW);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
