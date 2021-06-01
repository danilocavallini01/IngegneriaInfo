package favoliere.persistence.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.StringJoiner;



import favoliere.model.Scenario;
import favoliere.persistence.BadFileFormatException;
import favoliere.persistence.ScenariLoader;


public class ScenariLoaderTest {

	private Reader baseReader;
	
	private Reader sintetizzaDaFrasi(String[] descrizioni, int[] indici) {
		StringJoiner sj = new StringJoiner(System.lineSeparator());
		for(int i=0; i<descrizioni.length; i++) sj.add(descrizioni[i] + "  #" + indici[i]);
		return new StringReader(sj.toString());
	}

	@Test
	public void testScenariLoader() throws IOException, BadFileFormatException {
		String[] descrizioni = {
				"nel bosco si incontrarono",
				"prigioniera in'una alta torre",
				"prigioniera di un orco in una cantina buia"				
		};
		int[] indici= {
				2,
				3,
				5				
		};
		baseReader = sintetizzaDaFrasi(descrizioni,indici);
		ScenariLoader loader = new ScenariLoader();
		loader.loadAllItems(baseReader);
		List<Scenario> scenari = loader.getItems();
		for(int i=0; i<scenari.size(); i++) {
			assertEquals(scenari.get(i).getDescrizione(), descrizioni[i]);
			assertEquals(scenari.get(i).getIndice(), indici[i]);
		}
	}
	
	@Test
	public void testScenariLoaderExceptionIndiceNumerico() throws IOException, BadFileFormatException {
		String[] descrizioni = {
				"nel bosco si incontrarono",
				"prigioniera in'una alta torre",
				"prigioniera di un orco in una cantina buia #ciao"				
		};
		int[] indici= {
				2,
				3,
				0				
		};
		baseReader = sintetizzaDaFrasi(descrizioni,indici);
		ScenariLoader loader = new ScenariLoader();
		
		 assertThrows(BadFileFormatException.class, () ->
		 	loader.loadAllItems(baseReader));
	     //   assertTrue(exception.getMessage().contains("indice non numerico"));
		}
	
	
	@Test
	public void testScenariLoaderExceptionDescrizione() throws IOException, BadFileFormatException {
		ScenariLoader loader = new ScenariLoader();
		assertThrows(BadFileFormatException.class, () ->
			loader.loadAllItems(new StringReader("#4")));
		//	assertTrue(exception.getMessage().contains("descrizione vuota"));
	}


}
