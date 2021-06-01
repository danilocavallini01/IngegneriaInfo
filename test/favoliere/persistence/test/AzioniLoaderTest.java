package favoliere.persistence.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.StringJoiner;



import favoliere.model.Azione;
import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.AzioniLoader;


public class AzioniLoaderTest {

	private Reader baseReader;
	
	private Reader sintetizzaDaFrasi(String[] descrizioni, int[] indici) {
		StringJoiner sj = new StringJoiner(System.lineSeparator());
		for(int i=0; i<descrizioni.length; i++) sj.add(descrizioni[i] + "  #" + indici[i]);
		return new StringReader(sj.toString());
	}

	@Test
	public void testAzioniLoader() throws IOException, BadFileFormatException {
		String[] descrizioni = {
				"ando' a salvarla con la spada",
				"scalo' la torre con una lunga corda",
				"uccise l'orco con la spada, butto giu' la porta e la libero'"				
		};
		int[] indici= {
				2,
				2,
				4				
		};
		baseReader = sintetizzaDaFrasi(descrizioni,indici);
		AzioniLoader loader = new AzioniLoader();
		loader.loadAllItems(baseReader);
		List<Azione> azioni = loader.getItems();
		for(int i=0; i<azioni.size(); i++) {
			assertEquals(azioni.get(i).getDescrizione(), descrizioni[i]);
			assertEquals(azioni.get(i).getIndice(), indici[i]);
		}
	}

	@Test
	public void testAzioniLoaderExceptionIndice() throws IOException, BadFileFormatException {
		String[] descrizioni = {
				"ando' a salvarla con la spada",
				"scalo' la torre con una lunga corda",
				"uccise l'orco con la spada, butto giu' la porta e la libero' #blabla"
		};
		int[] indici= {
				2,
				2,
				4				
		};
		baseReader = sintetizzaDaFrasi(descrizioni,indici);
		AzioniLoader loader = new AzioniLoader();
		assertThrows(BadFileFormatException.class, () ->
		  loader.loadAllItems(baseReader));
		//assertTrue(exception.getMessage().contains("indice non numerico"));
	}

	
	@Test
	public void testAzioniLoaderExceptionDescrizione() throws IOException, BadFileFormatException {
		AzioniLoader loader = new AzioniLoader();
		assertThrows(BadFileFormatException.class, () ->
			loader.loadAllItems(new StringReader("#4")));
		//assertTrue(exception.getMessage().contains("descrizione vuota"));
	}

}
