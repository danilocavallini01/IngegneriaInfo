package favoliere.ui;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Optional;

import favoliere.controller.Controller;
import favoliere.controller.MyController;

import favoliere.model.FasciaEta;
import favoliere.model.Favola;
import favoliere.model.Impressionabilita;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainPane extends BorderPane {
	private ComboBox<FasciaEta> etaBox;
	private ComboBox<Impressionabilita> impBox;
	private TextArea output;
	private Button genera;
	private Button stampa;
	private Controller controller;
	private Favola favola;

	public MainPane(Controller controller) {
		favola = null;
		this.controller = controller;

		VBox box = new VBox();

		Label etaLabel = new Label("Fascia d'età del bambino: ");
		etaBox = new ComboBox<FasciaEta>(FXCollections.observableArrayList(FasciaEta.values()));
		etaBox.setValue(FasciaEta.PICCOLISSIMO);

		Label impLabel = new Label("Fascia d'età del bambino: ");
		impBox = new ComboBox<Impressionabilita>(FXCollections.observableArrayList(Impressionabilita.values()));
		impBox.setValue(Impressionabilita.PERNULLA_IMPRESSIONABILE);

		Label favolaLabel = new Label("Favola generata: ");
		output = new TextArea();

		genera = new Button("Genera Favola");
		genera.setOnAction(e -> {
			Optional<Favola> favop;
			if ((favop = controller.generaFavola(etaBox.getValue(), impBox.getValue())).isPresent()) {
				favola = favop.get();
				output.setText(favola.toString());
				stampa.setDisable(false);
			} else {
				Controller.alert("Nessuna favola disponibile con questi parametri :/", "", "");
			}
		});
		
		genera.setStyle("-fx-background-color: pink");

		stampa = new Button("Stampa su file");
		stampa.setDisable(true);
		stampa.setOnAction(e -> {
			try {
				PrintWriter pw = new PrintWriter(controller.getOutputFileName());
				pw.toString();
			} catch(Exception err) {
				Controller.alert(err.getMessage(), "", "");
			}
		});
		stampa.setStyle("-fx-background-color: orange");
		
		box.setSpacing(20);
		box.setPadding(new Insets(30));
		

		box.setAlignment(Pos.TOP_LEFT);
		box.getChildren().add(etaLabel);
		box.getChildren().add(etaBox);
		box.getChildren().add(impLabel);
		box.getChildren().add(impBox);
		box.getChildren().add(favolaLabel);
		box.getChildren().add(output);
		box.getChildren().add(genera);
		box.getChildren().add(stampa);

		this.setCenter(box);
	}
}
