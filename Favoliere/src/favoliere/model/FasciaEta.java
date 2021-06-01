package favoliere.model;

public enum FasciaEta {
	PICCOLISSIMO(2), PICCOLO(3), GRANDICELLO(4), GRANDE(5);
	
	private int gradoComplessita;

	private FasciaEta(int gradoComplessita) {
		this.gradoComplessita = gradoComplessita;
	}

	public int getGradoComplessita() {
		return gradoComplessita;
	}
	
	
}
