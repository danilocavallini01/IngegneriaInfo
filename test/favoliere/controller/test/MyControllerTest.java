package favoliere.controller.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import org.junit.jupiter.api.*;

import favoliere.controller.Controller;
import favoliere.controller.MyController;
import favoliere.model.FasciaEta;
import favoliere.model.Favola;
import favoliere.model.Impressionabilita;

public class MyControllerTest {
	
	private Controller controller;
	
	@BeforeEach
	public void genController() {
		//test del costruttore testa anche il metodo load
		controller = new MyController(new PersonaggiLoaderMock(), "Personaggi.txt", new ScenariLoaderMock(), "Scenari.txt",
				new AzioniLoaderMock(), "Azioni.txt", new ConclusioniLoaderMock(), "Conclusioni.txt","Favola.txt");
	}
	
	@Test
	public void testGetImpressionabilita() {
		assertArrayEquals(controller.getLivelliImpressionabilita(),Impressionabilita.values());
	}

	@Test
	public void testGetFasceEta() {
		assertArrayEquals(controller.getFasceEta(), FasciaEta.values());
	}
		
	@Test
	public void testGetOutputFileName() {
		assertEquals(controller.getOutputFileName(), "Favola.txt");
	}
	
	@Test
	public void testGeneraFavola() {
		Optional<Favola> favola = controller.generaFavola(FasciaEta.GRANDE,Impressionabilita.PERNULLA_IMPRESSIONABILE);
		assertTrue(favola.isPresent());
		
		Optional<Favola> favolaEmpty = controller.generaFavola(FasciaEta.PICCOLISSIMO,Impressionabilita.MOLTO_IMPRESSIONABILE);
		assertFalse(favolaEmpty.isPresent());
	}
}
