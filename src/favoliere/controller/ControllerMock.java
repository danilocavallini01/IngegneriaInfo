package favoliere.controller;

import favoliere.model.Sintetizzatore;
import favoliere.model.Tipologia;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import favoliere.model.Azione;
import favoliere.model.Conclusione;
import favoliere.model.Esordio;
import favoliere.model.FasciaEta;
import favoliere.model.Favola;
import favoliere.model.Impressionabilita;
import favoliere.model.MySintetizzatore;
import favoliere.model.Personaggio;
import favoliere.model.Scenario;

public class ControllerMock implements Controller {

	private String outputFileName;
	@SuppressWarnings("unused")
	private Sintetizzatore sintetizzatore;
	private List<Personaggio> personaggi;
	private Set<Personaggio> personaggiBuoni;
	private Set<Personaggio> personaggiCattivi;
	private List<Scenario> scenari;
	private List<Azione> azioni;
	private List<Conclusione> conclusioni;
	private boolean generated = true;
			
	public ControllerMock(String outputFileName) {
		this.outputFileName = outputFileName;
		
		personaggiBuoni  = Set.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco")
				);
		
		personaggiCattivi  = Set.of(
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio")
				);
		
		personaggi  = List.of(
				new Personaggio("la principessa Catlyn", Tipologia.POSITIVO, "una principessa bionda ma molto sola"),
				new Personaggio("il principe William", Tipologia.POSITIVO, "un principe alto e nobile, sempre in sella al fido Alfius, il suo cavallo bianco"),
				new Personaggio("Urcus", Tipologia.NEGATIVO, "un orco molto cattivo e feroce"),
				new Personaggio("Arfelius", Tipologia.NEGATIVO, "un drago enorme e malvagio")
				);
		
		scenari = List.of(
				new Scenario("nel bosco si incontrarono",2),
				new Scenario("prigioniera in'una alta torre",3),
				new Scenario("prigioniera di un orco in una cantina buia",5)
				);
		
		azioni = List.of(
				new Azione("and� a salvarla con la spada",2),
				new Azione("scal� la torre con una lunga corda",2),
				new Azione("uccise l'orco con la spada, butto gi� la porta e la liber�",4)
				);
		
		conclusioni = List.of(
				new Conclusione("e infine vissero tutti felici e contenti"),
				new Conclusione("quindi si sposarono e vissero felici per molti anni")
				);
		
		this.sintetizzatore = new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
	}

	@Override
	public Impressionabilita[] getLivelliImpressionabilita() {
		return Impressionabilita.values();
	}

	@Override
	public FasciaEta[] getFasceEta() {
		return FasciaEta.values();
	}

	@Override
	public String getOutputFileName() {
		return outputFileName;
	}

	@Override
	public Optional<Favola> generaFavola(FasciaEta eta, Impressionabilita livelloImpressionabilita) {	
		if(generated) {
			generated = false;
			return(Optional.of(new Favola(new Esordio(personaggiBuoni,personaggiCattivi),scenari.get(0),azioni.get(0),conclusioni.get(0))));
		}
		generated = true; 
		return(Optional.of(new Favola(new Esordio(personaggiBuoni,personaggiCattivi),scenari.get(1),azioni.get(1),conclusioni.get(1))));

	}

}
