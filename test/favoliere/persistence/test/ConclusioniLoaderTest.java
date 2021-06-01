package favoliere.persistence.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;


import favoliere.model.Conclusione;
import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.ConclusioniLoader;


public class ConclusioniLoaderTest {

	private Reader baseReader;
	
	@Test
	public void testReadConclusione() throws IOException, BadFileFormatException {
		baseReader = new StringReader(
				"E vissero tutti felici e contenti" + System.lineSeparator() +
				"Quindi si sposarono e vissero felici per molti anni" + System.lineSeparator()
		);
		ConclusioniLoader loader = new ConclusioniLoader();
		loader.loadAllItems(baseReader);
		List<Conclusione> conclusioni = loader.getItems();
		assertEquals(conclusioni.get(0).getConclusione(), "E vissero tutti felici e contenti");
		assertEquals(conclusioni.get(1).getConclusione(), "Quindi si sposarono e vissero felici per molti anni");
	}

	@Test
	public void testLanicaEccezioneConclusione() throws IOException, BadFileFormatException {
		baseReader = new StringReader(
				"E vissero tutti felici e contenti" + System.lineSeparator() +
				"" + System.lineSeparator()
		);
		ConclusioniLoader loader = new ConclusioniLoader();
		assertThrows(BadFileFormatException.class, () ->
		  loader.loadAllItems(baseReader));
	    // assertTrue(exception.getMessage().contains("riga vuota"));
	}

}
