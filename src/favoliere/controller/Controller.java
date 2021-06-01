package favoliere.controller;

import java.util.Optional;

import favoliere.model.FasciaEta;
import favoliere.model.Favola;
import favoliere.model.Impressionabilita;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public interface Controller {

	Impressionabilita[] getLivelliImpressionabilita();
	FasciaEta[] getFasceEta();
	String getOutputFileName();
	Optional<Favola> generaFavola(FasciaEta eta, Impressionabilita livelloImpressionabilita);
	
	public static void alert(String title, String headerMessage, String contentMessage) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(headerMessage);
		alert.setContentText(contentMessage);
		alert.showAndWait();
	}

}