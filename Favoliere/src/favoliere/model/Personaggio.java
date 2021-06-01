package favoliere.model;

public class Personaggio implements Comparable<Personaggio>{
	private String nome, descrizione;
	private Tipologia tipologia; 
	
	public Personaggio(String nome, Tipologia tipologia, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipologia = tipologia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Tipologia getTipologia() {
		return tipologia;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Personaggio other = (Personaggio) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipologia != other.tipologia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome +", " + descrizione;
	}

	@Override
	public int compareTo(Personaggio that) {
		return this.getNome().compareToIgnoreCase(that.getNome());
	}
	
}
