package favoliere.model;

import java.util.List;

public interface Sintetizzatore {
	List<Personaggio> getPersonaggi();
	List<Scenario> getScenari();
	List<Azione> getAzioni();
	List<Conclusione> getConclusioni();
	Favola generaFavola(FasciaEta eta, Impressionabilita livelloImpressionabilita) throws NoSuchTaleException;
}
