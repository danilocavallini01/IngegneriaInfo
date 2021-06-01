package favoliere;

import favoliere.controller.Controller;
import favoliere.controller.ControllerMock;
import favoliere.ui.MainPane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FavoliereMock extends FavoliereApp {
	public final String OUTPUT_FILE_NAME = "Favola.txt";
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Il Favoliere");

		Controller controller = new ControllerMock(OUTPUT_FILE_NAME);
		
		MainPane mainPanel = new MainPane(controller);

		Scene scene = new Scene(mainPanel, 600, 400, Color.YELLOW);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

