
public class CodiceFiscale {
	public static void main(String[] args) {
		
	CodiceFiscale CodiceFiscale = new CodiceFiscale();
		
	System.out.println(CodiceFiscale.calcolaCodiceFiscale(
			"Mario", "Rossi", 12, 6, 1976, "M", "Bologna").equals("RSSMRA76H12A944I"));
	
	System.out.println(CodiceFiscale.calcolaCodiceFiscale(
			"Mario", "Rossi", 1, 1, 1990, "M", "Milano").equals("RSSMRA90A01F205Z"));
	
	System.out.println(CodiceFiscale.verificaCodiceFiscale(
			"Mario", "Rossi", 12, 6, 1976, "M", "Bologna", "RSSMRA76H12A94QF"));
	
	System.out.println(CodiceFiscale.verificaCodiceFiscale(
			"Mario", "Rossi", 12, 6, 1976, "M", "Bologna", "RSSMRA76H12A9Q4U"));
	
	System.out.println(CodiceFiscale.verificaCodiceFiscale(
			"Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90A01F20RU"));
	
	System.out.println(CodiceFiscale.verificaCodiceFiscale(
			"Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90A01F2L5K"));
	
	System.out.println(CodiceFiscale.verificaCodiceFiscale(
			"Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90A01FN05O"));
	
	System.out.println(CodiceFiscale.verificaCodiceFiscale(
			"Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90A0MF205R"));
	
	System.out.println(CodiceFiscale.verificaCodiceFiscale(
			"Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90AL1F205K"));
	
	}
	
	final private String vocali = "AEIOU";
	final private String mesiTab = "ABCDEHLMPRST" ;
	final private int woman_const = 40;
	final private String milano_cod = "F205";
	final private String bologna_cod = "A944";
	// zero voglia di mettere tutta la lista comuni
	
	final private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final private String dispAlphabet = "BAKPLCQDREVOSFTGUHMINJWZYX";
	
	final private String omocodia = "LMNPQRSTUV";
	
	
	public String calcolaCodiceFiscale(String nome, String cognome, int giorno, int mese, int anno, String sesso, String comune ) {
		String partialResult = this.calcolaCognome(cognome) + this.calcolaNome(nome) + this.calcolaAnno(anno) + this.calcolaMese(mese)
			+ this.calcolaGiornoSesso(giorno, sesso) + this.calcolaComune(comune);
		
		return partialResult + this.calcolaCarControllo(partialResult);
	}
	
	public boolean verificaCodiceFiscale(String cognome, String nome, int giorno, int mese, int anno, String comune, String sesso, String CF) {
		String CalculatedCF = this.calcolaCodiceFiscale(cognome, nome, giorno, mese, anno, comune, sesso);
		
		String charCF = new String();
		String charCalculatedCF = new String();
		
		for( int i = 0; i < CF.length() -1; i++) {
			charCF = String.valueOf(CF.charAt(i));
			charCalculatedCF =  String.valueOf(CalculatedCF.charAt(i));
			
			if( !charCF.equals(charCalculatedCF)) {
				if(!charCF.equals(String.valueOf(omocodia.charAt(Integer.valueOf(charCalculatedCF))))) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	private String calcolaComune(String comune) {
		String uppedComune = comune.toUpperCase();
		if(uppedComune.equals("BOLOGNA")) {
			return bologna_cod;
		} else if(uppedComune.equals("MILANO")) {
			return milano_cod;
		} else {
			return "FRAH";
		}
	}
	
	private String calcolaGiornoSesso(int giorno, String sesso) {
		String result = new String();
		
		if(sesso.equals("M")) {
			result = String.valueOf(giorno);
		} else {
			result = String.valueOf(giorno + woman_const);
		}
		
		if(result.length() == 1) {
			result = "0" + result;
		}
		
		return result;
	}
	
	private String calcolaMese(int mese) {
		return String.valueOf(mesiTab.charAt(mese - 1));
	}
	
	private String calcolaAnno(int anno) {
		String nascita = String.valueOf(anno % 100);
		if(nascita.length() == 1) {
			nascita = "0" + nascita;
		}
		return nascita;
	}
	
	private String calcolaCarControllo(String CFincompleto) {
		int result = 0;
		String charCF = new String();
		String ParsedCF = new String();
		
		for (int i = 0; i< CFincompleto.length() ; i++) {
			charCF = String.valueOf(CFincompleto.charAt(i));
			if(alphabet.contains(charCF)) {
				ParsedCF += charCF;
			} else {
				ParsedCF += alphabet.charAt(Integer.valueOf(charCF));
			}
		}
		
		for (int i = 0; i < ParsedCF.length(); i++) {
			charCF = String.valueOf(ParsedCF.charAt(i));
			
			if(i % 2 != 0) {
				result += alphabet.indexOf(charCF);
			} else {
				result += dispAlphabet.indexOf(charCF);
			}
			
		}
		return String.valueOf(alphabet.charAt(result % 26));
	}
	
	private String calcolaCognome(String cognome) {
		
		String uppedCognome = cognome.toUpperCase();
		String result = new String(); 
		
		if(uppedCognome.length() < 3) {
			result = uppedCognome;
			for(int i = uppedCognome.length(); i < 3; i++) {
				result += "X";
			}
			return result;
		}
		
		
		for(int i = 0; i < uppedCognome.length() && result.length() < 3; i++) {
			if(isConsonante(uppedCognome.charAt(i))) {
				result += uppedCognome.charAt(i);
			}
		}
		
		if(result.length() < 3) {
			for(int i = 0; i < uppedCognome.length() && result.length() < 3; i++) {
				if(isVocale(uppedCognome.charAt(i))) {
					result += uppedCognome.charAt(i);
				}
			}
		}
		
		return result;
	}
	
	private String calcolaNome(String nome) {
		String uppedNome = nome.toUpperCase();
		String result = new String();
		
		if(uppedNome.length() < 3) {
			result = uppedNome;
			for(int i = uppedNome.length(); i < 3; i++) {
				result += "X";
			}
			return result;
		}
		
		for(int i = 0; i < uppedNome.length() && result.length() < 4; i++) {
			if(isConsonante(uppedNome.charAt(i))) {
				result += uppedNome.charAt(i);
			}
		}
		
		if( result.length() < 4) {
			return this.calcolaCognome(uppedNome);
		}
		
		return result;
		
	}
	
	private boolean isVocale(char c) {
		return this.vocali.contains(String.valueOf(c));
	}
	
	private boolean isConsonante(char c) {
		return !this.isVocale(c);
	}
	
}
