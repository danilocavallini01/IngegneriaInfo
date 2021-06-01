package favoliere.controller;

import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.SectionLoader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import favoliere.model.Azione;
import favoliere.model.Conclusione;
import favoliere.model.FasciaEta;
import favoliere.model.Favola;
import favoliere.model.Impressionabilita;
import favoliere.model.NoSuchTaleException;
import favoliere.model.Personaggio;
import favoliere.model.Scenario;

public class MyController extends BaseController {

	public MyController(SectionLoader<Personaggio> lp, String fileNamePersonaggi, SectionLoader<Scenario> ls, String fileNameScenari, 
			SectionLoader<Azione> la, String fileNameAzioni, SectionLoader<Conclusione> lc, String fileNameConclusioni, String outputFileName) {
		super(lp, fileNamePersonaggi, ls, fileNameScenari, la, fileNameAzioni, lc, fileNameConclusioni, outputFileName);
	}

	@Override
	public Optional<Favola> generaFavola(FasciaEta eta, Impressionabilita livelloImpressionabilita) {
		try {
			return Optional.ofNullable(getSintetizzatore().generaFavola(eta, livelloImpressionabilita));
		} catch (NoSuchTaleException e) {
			return Optional.empty();
		}
	}
	
	@Override
	protected <T> List<T> load(String filename, SectionLoader<T> loader){
		try (FileReader baseReader = new FileReader(filename)) {
			loader.loadAllItems(baseReader);
		}
		catch (IOException e) {
			Controller.alert("Errore irrecuperabile", "Errore di I/O nella lettura del file " + filename, "Addio");
			System.exit(1);
		} 
		catch (BadFileFormatException e) {
			Controller.alert("Errore irrecuperabile", "Formato del file " + filename + " errato", "Addio");
			System.exit(2);
		}
		return loader.getItems();
	}

}
