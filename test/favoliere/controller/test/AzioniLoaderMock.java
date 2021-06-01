package favoliere.controller.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import favoliere.model.Azione;
import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.SectionLoader;


public class AzioniLoaderMock implements SectionLoader<Azione> {

	private List<Azione> azioni;
	
	@Override
	public void loadAllItems(Reader baseReader) throws IOException, BadFileFormatException {
		azioni = List.of(
				new Azione("andò a salvarla con la spada",5),
				new Azione("scalò la torre con una lunga corda",5),
				new Azione("uccise l'orco con la spada, butto giù la porta e la liberò",5)
				);
	}
	
	
	@Override
	public List<Azione> getItems() {
		return azioni;
	}


}
