package favoliere.model;

import java.util.StringJoiner;
import java.util.Set;


public class Favola {
	private Esordio esordio;
	private Scenario scenario;
	private Azione azione;
	private Conclusione conclusione;
	
	public Esordio 	getEsordio()  { return esordio;}
	public Scenario getScenario() { return scenario;}
	public Azione 	getAzione()   { return azione;}
	public Conclusione getConclusione() { return conclusione;}
	
	public int getIndiceComplessitaScenario() { return scenario.getIndice();}
	public int getIndiceDurezzaAzione() { return azione.getIndice();}
	
	public Set<Personaggio> getPersonaggi() { return esordio.getPersonaggi();}
	public Set<Personaggio> getPersonaggiBuoni() { return esordio.getPersonaggiBuoni();}
	public Set<Personaggio> getPersonaggiCattivi() { return esordio.getPersonaggiCattivi();}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(".\n");
		sj.add(esordio.toString());
		sj.add("Un bel giorno, "+esordio.toStringNomiPersonaggi()+" si incontrarono "+scenario.toString());
		sj.add("In quel luogo, "+esordio.getPersonaggiBuoni().toArray()[0]+" "+azione.toString());
		sj.add(conclusione.toString());
		return sj.toString();
	}
	
	public Favola(Esordio esordio, Scenario scenario, Azione azione, Conclusione conclusione) {
		this.esordio = esordio;
		this.scenario = scenario;
		this.azione = azione;
		this.conclusione = conclusione;
	}
}
