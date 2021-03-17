package fractioncollection;
import frazione.Frazione;

public class CollectionMain {
	

  public static void main(String[] args) {
	  
	  FractionCollection collezioneA = new FractionCollection(10);
	  collezioneA.put(new Frazione(1,3));
	  collezioneA.put(new Frazione(2,3));
	  collezioneA.put(new Frazione(-1,2));
	  collezioneA.put(new Frazione(1,6));
	  
	  FractionCollection collezioneB = new FractionCollection(12);
	  collezioneB.put(new Frazione(1,5));
	  collezioneB.put(new Frazione(2,8));
	  collezioneB.put(new Frazione(1,7));
	  collezioneB.put(new Frazione(-1,6));
	  
	  FractionCollection somma = collezioneA.sum(collezioneB);
	  System.out.println(somma.toString());
	  
	  FractionCollection prodotto = collezioneA.mul(collezioneB);
	  System.out.println(prodotto.toString());
  }
  
}