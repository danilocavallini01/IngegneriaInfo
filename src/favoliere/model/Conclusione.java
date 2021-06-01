package favoliere.model;

public class Conclusione {

	private String frase = null;
	
	public Conclusione(String frase) {
		if (frase==null || frase.equals("")) throw new IllegalArgumentException("conclusione nulla o vuota");
		this.frase = frase; 
	}

	public String getConclusione()  {
		return frase;
	}

	@Override
	public String toString()  {
		return getConclusione();
	}

}
