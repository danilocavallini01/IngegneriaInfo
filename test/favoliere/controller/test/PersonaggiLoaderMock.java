package favoliere.controller.test;

import java.io.IOException;
import java.util.List;
import java.io.Reader;
import favoliere.model.Personaggio;
import favoliere.model.Tipologia;
import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.SectionLoader;


public class PersonaggiLoaderMock implements SectionLoader<Personaggio> {

	private List<Personaggio> personaggi;
	
	@Override
	public void loadAllItems(Reader baseReader) throws IOException, BadFileFormatException {
		personaggi = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco"),
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio"));
	}
	
	@Override
	public List<Personaggio> getItems() {
		return personaggi;
	}


}
