package favoliere.controller.test;

import java.io.IOException;
import java.util.List;
import java.io.Reader;

import favoliere.model.Conclusione;
import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.SectionLoader;


public class ConclusioniLoaderMock implements SectionLoader<Conclusione> {

	private List<Conclusione> conclusioni;
	
	@Override
	public void loadAllItems(Reader baseReader) throws IOException, BadFileFormatException {
		conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
	}
	
	@Override
	public List<Conclusione> getItems() {
		return conclusioni;
	}


}
