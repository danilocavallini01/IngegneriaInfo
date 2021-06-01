package favoliere.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import favoliere.model.Conclusione;

public class ConclusioniLoader implements SectionLoader<Conclusione> {

	private List<Conclusione> conclusioni;
	
	@Override
	public void loadAllItems(Reader baseReader) throws IOException, BadFileFormatException {
		conclusioni = new ArrayList<>();
		BufferedReader reader = new BufferedReader(baseReader);
		String riga = null;
		while ((riga = reader.readLine()) != null) {
			if (riga.trim().isEmpty()) throw new BadFileFormatException("riga vuota in conclusioni");
			conclusioni.add(new Conclusione(riga.trim()));
		}
	}
	
	@Override
	public List<Conclusione> getItems() {
		return conclusioni;
	}

}
