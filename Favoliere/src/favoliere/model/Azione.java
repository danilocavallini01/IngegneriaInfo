package favoliere.model;

public class Azione implements ConIndice {

	private int indiceDurezza;
	private String descrizione;
	
	public Azione(String descrizione,int indiceDurezza) {
		if (indiceDurezza<1 || indiceDurezza>5) throw new IllegalArgumentException("indice durezza fuori range:" + indiceDurezza);
		if (descrizione==null || descrizione.equals("")) throw new IllegalArgumentException("descrizione nulla o vuota");
		this.indiceDurezza = indiceDurezza;
		this.descrizione = descrizione;
	}

	@Override
	public int getIndice() {
		return indiceDurezza;
	}

	public String getDescrizione() {
		return descrizione;
	}

	@Override
	public String toString() {
		return getDescrizione();
	}
	
}
