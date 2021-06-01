package favoliere.model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.List;

import favoliere.model.Azione;
import favoliere.model.Conclusione;
import favoliere.model.MySintetizzatore;
import favoliere.model.Personaggio;
import favoliere.model.Scenario;
import favoliere.model.Sintetizzatore;
import favoliere.model.Tipologia;

public class MySintetizzatoreBasicTest {
	
	private List<Personaggio> personaggi;
	private List<Scenario> 	  scenari; 
	private List<Azione> 	  azioni;
	private List<Conclusione> conclusioni;
	private Sintetizzatore synth;
	
	@BeforeEach
	public void genSintetizzatore() {
		personaggi  = List.of(	new Personaggio("Candy", Tipologia.POSITIVO, "una bimba bionda"),
								new Personaggio("TinTin", Tipologia.POSITIVO, "un bimbo biondo"));
		scenari 	  = List.of(new Scenario("un castello nel bosco", 1),
								new Scenario("un bosco incantato", 2));
		azioni  	  = List.of(new Azione("liber� la principessa", 1),
								new Azione("salv� la principessa dall'orco", 4));
		conclusioni = List.of(new Conclusione("E vissero per sempre felici e contenti"),
								new Conclusione("Ed ebbero molti figli felici non ingegneri"));
		synth = new MySintetizzatore(personaggi,scenari,azioni,conclusioni);		
	}
	
	@Test
	public void testGetPersonaggi() {
		assertEquals(synth.getPersonaggi(), personaggi);
	}
	@Test
	public void testGetScenari() {
		assertEquals(synth.getScenari(), scenari);
	}
	@Test
	public void testGetAzioni() {
		assertEquals(synth.getAzioni(), azioni);
	}
	@Test
	public void testGetConclusioni() {
		assertEquals(synth.getConclusioni(), conclusioni);
	}

}
