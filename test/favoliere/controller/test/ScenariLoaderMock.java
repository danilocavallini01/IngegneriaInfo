package favoliere.controller.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import favoliere.model.Scenario;
import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.SectionLoader;


public class ScenariLoaderMock implements SectionLoader<Scenario> {

	private List<Scenario> scenari;
	
	public void loadAllItems(Reader baseReader) throws IOException, BadFileFormatException {
		scenari = List.of(new Scenario("un castello nel bosco", 5),
				new Scenario("un bosco incantato", 5));
	}
	
	
	public List<Scenario> getItems() {
		return scenari;
	}


}
