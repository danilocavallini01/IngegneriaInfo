package favoliere.model;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Esordio { 

	private Set<Personaggio> personaggiBuoni = null;
	private Set<Personaggio> personaggiCattivi = null;
	
	public Esordio(Set<Personaggio> personaggiBuoni, Set<Personaggio> personaggiCattivi) {
		if (personaggiBuoni==null || personaggiBuoni.isEmpty()) throw new IllegalArgumentException("lista personaggi buoni nulla o vuota");
		if (personaggiCattivi==null || personaggiCattivi.isEmpty()) throw new IllegalArgumentException("lista personaggi cattivi nulla o vuota");
		this.personaggiBuoni = personaggiBuoni;
		this.personaggiCattivi = personaggiCattivi;
	}

	public Set<Personaggio> getPersonaggi()  {
		Set<Personaggio> personaggi = new TreeSet<Personaggio>();
		personaggi.addAll(personaggiBuoni);
		personaggi.addAll(personaggiCattivi);
		return personaggi;
	}
	
	public Set<Personaggio> getPersonaggiBuoni()  {
		return personaggiBuoni;
	}
	
	public Set<Personaggio> getPersonaggiCattivi()  {
		return personaggiCattivi;
	}
	
	//RC
	public String toStringNomiPersonaggi()  {
		StringJoiner sj = new StringJoiner(", ");
		for(Personaggio p:getPersonaggi())
			sj.add(p.getNome());
		return sj.toString();
	}

	@Override	
	public String toString() {
		StringJoiner sj = new StringJoiner(" e ");
		for(Personaggio p : getPersonaggi())
			sj.add(p.toString());
		return "C'era una volta " + sj.toString();
	}

}
