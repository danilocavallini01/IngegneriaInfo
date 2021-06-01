package favoliere.model;

public class Scenario implements ConIndice {

	private int indiceComplessita;
	private String descrizione;
	
	public Scenario(String descrizione, int indiceComplessita) {
		if (indiceComplessita<1 || indiceComplessita>5) throw new IllegalArgumentException("indice complessit� fuori range:" + indiceComplessita);
		if (descrizione==null || descrizione.equals("")) throw new IllegalArgumentException("descrizione nulla o vuota");
		this.indiceComplessita = indiceComplessita;
		this.descrizione = descrizione;
	}
	
	@Override
	public int getIndice() {
		return indiceComplessita;
	}

	public String getDescrizione() {
		return descrizione;
	}

	@Override
	public String toString() {
		return getDescrizione();
	}
	
}
