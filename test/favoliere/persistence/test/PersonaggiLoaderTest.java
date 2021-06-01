package favoliere.persistence.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;



import favoliere.model.Personaggio;
import favoliere.model.Tipologia;
import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.PersonaggiLoader;


public class PersonaggiLoaderTest {

	private Reader baseReader;

	@Test
	public void testPersonaggiLoader() throws IOException, BadFileFormatException {
		baseReader = new StringReader(
				"POSITIVO: la principessa Catlyn : una principessa bionda ma molto sola" + System.lineSeparator() +
				"POSITIVO: il principe William : un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco" + System.lineSeparator() +
				"NEGATIVO: Urcus : un orco molto cattivo e feroce" + System.lineSeparator()
		);
		PersonaggiLoader loader = new PersonaggiLoader();
		loader.loadAllItems(baseReader);
		List<Personaggio> personaggi = loader.getItems();
		assertEquals(personaggi.get(0).getDescrizione(), "una principessa bionda ma molto sola");
		assertEquals(personaggi.get(1).getDescrizione(), "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco");
		assertEquals(personaggi.get(2).getDescrizione(), "un orco molto cattivo e feroce");
		assertEquals(personaggi.get(0).getTipologia(), Tipologia.POSITIVO);
		assertEquals(personaggi.get(1).getTipologia(), Tipologia.POSITIVO);
		assertEquals(personaggi.get(2).getTipologia(), Tipologia.NEGATIVO);
		assertEquals(personaggi.get(0).getNome(), "la principessa Catlyn");
		assertEquals(personaggi.get(1).getNome(), "il principe William");
		assertEquals(personaggi.get(2).getNome(), "Urcus");
	}

	@Test
	public void testNoTipologia() throws IOException, BadFileFormatException {
		baseReader = new StringReader(
				"XXXXXXXX: la principessa Catlyn : una principessa bionda ma molto sola" + System.lineSeparator() +
				"POSITIVO: il principe William : un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco" + System.lineSeparator() +
				"NEGATIVO: Urcus : un orco molto cattivo e feroce" + System.lineSeparator()
		);
		PersonaggiLoader loader = new PersonaggiLoader();
				
		assertThrows(BadFileFormatException.class, () ->
		 loader.loadAllItems(baseReader));
	    // assertTrue(exception.getMessage().contains("tipologia") && exception.getMessage().contains("XXXXXXXX")); //verifica che il messaggio di errore sia tipo "Mancanza tipologia in personaggio: XXXXXXXX:"
		
	}
	
	@Test
	public void testNomeVuoto() throws IOException, BadFileFormatException {
		baseReader = new StringReader(
				"POSITIVO: : una principessa bionda ma molto sola" + System.lineSeparator() +
				"POSITIVO: il principe William : un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco" + System.lineSeparator() +
				"NEGATIVO: Urcus : un orco molto cattivo e feroce" + System.lineSeparator()
		);
		PersonaggiLoader loader = new PersonaggiLoader();
		assertThrows(BadFileFormatException.class, () ->
		 loader.loadAllItems(baseReader));
		// assertTrue(exception.getMessage().contains("nome") && exception.getMessage().contains("una principessa bionda ma molto sola")); //verifica che il messaggio sia del tipo "Mancanza nome in personaggio: POSITIVO: : una principessa bionda ma molto sola"
	}

	@Test
	public void testDescrizioneVuota() throws IOException, BadFileFormatException {
		baseReader = new StringReader(
				"POSITIVO: la principessa Catlyn: una principessa bionda ma molto sola" + System.lineSeparator() +
				"POSITIVO: il principe William : " + System.lineSeparator() +
				"NEGATIVO: Urcus : un orco molto cattivo e feroce" + System.lineSeparator()
		);
		PersonaggiLoader loader = new PersonaggiLoader();
		assertThrows(BadFileFormatException.class, () -> loader.loadAllItems(baseReader));
		//assertTrue(exception.getMessage().contains("descrizione") && exception.getMessage().contains("il principe William")); //verifica che il messaggio sia del tipo "Mancanza descrizione in personaggio: POSITIVO: il principe William"
	}
}
