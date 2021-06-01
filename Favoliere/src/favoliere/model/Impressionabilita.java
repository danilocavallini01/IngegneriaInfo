package favoliere.model;

public enum Impressionabilita { 
	PERNULLA_IMPRESSIONABILE("per nulla impressionabile",5),
	POCO_IMPRESSIONABILE("poco impressionabile",4), 
	IMPRESSIONABILE("abbastanza impressionabile",3), 
	MOLTO_IMPRESSIONABILE("molto impressionabile",2); 
	
	private int livelloDurezza;
	private String grado;
	
	private Impressionabilita(String grado, int livelloDurezza) {
		this.grado=grado;
		this.livelloDurezza = livelloDurezza;
	}
	
	@Override
	public String toString() {return this.grado;}

	public int getGradoDurezza() {
		return livelloDurezza;
	}
	
}
