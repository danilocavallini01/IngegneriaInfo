package favoliere.model.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import favoliere.model.*;

public class MySintetizzatoreTest {
	Sintetizzatore generatore;
	
	@Test
	public void testGenerazioneFavolaCorretta() throws NoSuchTaleException {
		
		List<Personaggio> personaggi  = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco"),
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio")
				);
		
		List<Scenario> scenari = List.of(
				new Scenario("nel bosco si incontrarono",2),
				new Scenario("prigioniera in'una alta torre",3),
				new Scenario("prigioniera di un orco in una cantina buia",5)
				);
		
		List<Azione> azioni = List.of(
				new Azione("andò a salvarla con la spada",2),
				new Azione("scalò la torre con una lunga corda",2),
				new Azione("uccise l'orco con la spada, butto giù la porta e la liberò",4)
				);
		
		List<Conclusione> conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
		
		generatore= new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
		
		/*FAVOLA 1*/
		Favola favola = generatore.generaFavola(FasciaEta.GRANDE,Impressionabilita.PERNULLA_IMPRESSIONABILE);
		assertEquals(2,favola.getPersonaggiBuoni().size());
		assertEquals(1,favola.getPersonaggiCattivi().size());
		assertEquals(3,favola.getPersonaggi().size());
		assertTrue(favola.getIndiceDurezzaAzione()<=5);
		assertTrue(favola.getIndiceComplessitaScenario()<=5);
	}
	
	@Test
	public void testGenerazioneFavolaCorretta2() throws NoSuchTaleException {
		
		List<Personaggio> personaggi  = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco"),
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio")
				);
		
		List<Scenario> scenari = List.of(
				new Scenario("nel bosco si incontrarono",2),
				new Scenario("prigioniera in'una alta torre",3),
				new Scenario("prigioniera di un orco in una cantina buia",5)
				);
		
		List<Azione> azioni = List.of(
				new Azione("andò a salvarla con la spada",2),
				new Azione("scalò la torre con una lunga corda",3),
				new Azione("uccise l'orco con la spada, butto giù la porta e la liberò",4)
				);
		
		List<Conclusione> conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
		
		generatore= new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
		
		/*FAVOLA 2*/
		Favola favola = generatore.generaFavola(FasciaEta.PICCOLISSIMO,Impressionabilita.MOLTO_IMPRESSIONABILE);
		assertEquals(2,favola.getPersonaggiBuoni().size());
		assertEquals(1,favola.getPersonaggiCattivi().size());
		assertEquals(3,favola.getPersonaggi().size());
		assertTrue(favola.getIndiceDurezzaAzione()<=2);
		assertTrue(favola.getIndiceComplessitaScenario()<=2);
		assertTrue(favola.getScenario().getDescrizione().equals("nel bosco si incontrarono"));
		assertTrue(favola.getAzione().getDescrizione().equals("andò a salvarla con la spada"));
		
		/*FAVOLA 3*/
		favola = generatore.generaFavola(FasciaEta.PICCOLO,Impressionabilita.IMPRESSIONABILE);
		assertEquals(2,favola.getPersonaggiBuoni().size());
		assertEquals(1,favola.getPersonaggiCattivi().size());
		assertEquals(3,favola.getPersonaggi().size());
		assertTrue(favola.getIndiceDurezzaAzione()<=3);
		assertTrue(favola.getIndiceComplessitaScenario()<=3);
		
	}
	
	@Test
	public void testGenerazioneFavolaCorretta3() throws NoSuchTaleException {
		
		List<Personaggio> personaggi  = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco"),
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio")
				);
		
		List<Scenario> scenari = List.of(
				new Scenario("nel bosco si incontrarono",2),
				new Scenario("prigioniera in'una alta torre",4),
				new Scenario("prigioniera di un orco in una cantina buia",5)
				);
		
		List<Azione> azioni = List.of(
				new Azione("andò a salvarla con la spada",2),
				new Azione("scalò la torre con una lunga corda",4),
				new Azione("uccise l'orco con la spada, butto giù la porta e la liberò",4)
				);
		
		List<Conclusione> conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
		
		generatore= new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
				
		/*FAVOLA 3*/
		Favola favola = generatore.generaFavola(FasciaEta.PICCOLO,Impressionabilita.IMPRESSIONABILE);
		assertEquals(2,favola.getPersonaggiBuoni().size());
		assertEquals(1,favola.getPersonaggiCattivi().size());
		assertEquals(3,favola.getPersonaggi().size());
		assertTrue(favola.getIndiceDurezzaAzione()<=3);
		assertTrue(favola.getIndiceComplessitaScenario()<=3);
		assertTrue(favola.getScenario().getDescrizione().equals("nel bosco si incontrarono"));
		assertTrue(favola.getAzione().getDescrizione().equals("andò a salvarla con la spada"));
		
	}
	
	@Test
	public void testExceptionGenerazioneDuePersonaggiBuoni(){
		
		List<Personaggio> personaggi  = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio")
				);
		
		List<Scenario> scenari = List.of(
				new Scenario("nel bosco si incontrarono",5),
				new Scenario("prigioniera in'una alta torre",5),
				new Scenario("prigioniera di un orco in una cantina buia",5)
				);
		
		List<Azione> azioni = List.of(
				new Azione("andò a salvarla con la spada",5),
				new Azione("scalò la torre con una lunga corda",5),
				new Azione("uccise l'orco con la spada, butto giù la porta e la liberò",5)
				);
		
		List<Conclusione> conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
		
		generatore= new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
		
		Exception exception = assertThrows(NoSuchTaleException.class, () ->
		generatore.generaFavola(FasciaEta.PICCOLISSIMO,Impressionabilita.MOLTO_IMPRESSIONABILE));
        assertEquals("Non ci sono sufficienti personaggi del tipo richiesto", exception.getMessage());		
	}
	
	@Test
	public void testExceptionGenerazioneUnPersonaggioCattivo(){
		
		List<Personaggio> personaggi  = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco")
				);
		
		List<Scenario> scenari = List.of(
				new Scenario("nel bosco si incontrarono",5),
				new Scenario("prigioniera in'una alta torre",5),
				new Scenario("prigioniera di un orco in una cantina buia",5)
				);
		
		List<Azione> azioni = List.of(
				new Azione("andò a salvarla con la spada",5),
				new Azione("scalò la torre con una lunga corda",5),
				new Azione("uccise l'orco con la spada, butto giù la porta e la liberò",5)
				);
		
		List<Conclusione> conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
		
		generatore= new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
		
		Exception exception = assertThrows(NoSuchTaleException.class, () ->
		generatore.generaFavola(FasciaEta.PICCOLISSIMO,Impressionabilita.MOLTO_IMPRESSIONABILE));
        assertEquals("Non ci sono sufficienti personaggi del tipo richiesto", exception.getMessage());
       
		
	}
	
	@Test
	public void testExceptionComplessita(){
		
		List<Personaggio> personaggi  = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco"),
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio")
				);
		
		List<Scenario> scenari = List.of(
				new Scenario("nel bosco si incontrarono",5),
				new Scenario("prigioniera in'una alta torre",5),
				new Scenario("prigioniera di un orco in una cantina buia",5)
				);
		
		List<Azione> azioni = List.of(
				new Azione("andò a salvarla con la spada",5),
				new Azione("scalò la torre con una lunga corda",5),
				new Azione("uccise l'orco con la spada, butto giù la porta e la liberò",5)
				);
		
		List<Conclusione> conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
		
		generatore= new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
		
		Exception exception = assertThrows(NoSuchTaleException.class, () ->
		generatore.generaFavola(FasciaEta.PICCOLISSIMO,Impressionabilita.MOLTO_IMPRESSIONABILE));
        assertEquals("Non esistono scenari con il grado di complessità richiesto", exception.getMessage());
       
		
	}
	
	@Test
	public void testExceptionDurezza(){
		List<Personaggio> personaggi  = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco"),
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio")
				);
		
		List<Scenario> scenari = List.of(
				new Scenario("nel bosco si incontrarono",2),
				new Scenario("prigioniera in'una alta torre",2),
				new Scenario("prigioniera di un orco in una cantina buia",2)
				);
		
		List<Azione> azioni = List.of(
				new Azione("andò a salvarla con la spada",5),
				new Azione("scalò la torre con una lunga corda",5),
				new Azione("uccise l'orco con la spada, butto giù la porta e la liberò",5)
				);
		
		List<Conclusione> conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
		
		generatore= new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
		
		Exception exception = assertThrows(NoSuchTaleException.class, () ->
		generatore.generaFavola(FasciaEta.PICCOLISSIMO,Impressionabilita.MOLTO_IMPRESSIONABILE));
        assertEquals("Non esistono azioni con il grado di durezza richiesto", exception.getMessage());
       
		
	}
	
}
