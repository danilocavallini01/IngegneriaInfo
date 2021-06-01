package favoliere.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MySintetizzatore implements Sintetizzatore{
    private List<Azione> azioni;
    private List<Conclusione> conclusioni;
    private List<Personaggio> personaggi;
    private List<Scenario> scenari;
    private final Random random;
    
    public List<Azione> getAzioni() {
        return azioni;
    }
    public List<Conclusione> getConclusioni() {
        return conclusioni;
    }
    public List<Personaggio> getPersonaggi() {
        return personaggi;
    }
    public List<Scenario> getScenari() {
        return scenari;
    }

    @Override
    public Favola generaFavola(FasciaEta eta, Impressionabilita livelloImpressionabilita) throws NoSuchTaleException {
        Set<Personaggio> buoni = personaggi.stream().filter(p -> p.getTipologia().equals(Tipologia.POSITIVO))
                .distinct()
                .limit(2)
                .collect(Collectors.toSet());
        Set<Personaggio> cattivi = personaggi.stream().filter(p -> p.getTipologia().equals(Tipologia.NEGATIVO))
                .distinct()
                .limit(1)
                .collect(Collectors.toSet());
        if(buoni.size() < 2 || cattivi.size() < 1) {
        	throw new NoSuchTaleException("Non ci sono sufficienti personaggi del tipo richiesto");
        }
    	
    	Scenario scen = null;
        for(Scenario s : this.scenari) {
        	if(s.getIndice() <= eta.getGradoComplessita() && scen == null) {
        		scen = s;
        	}
        }
        Azione action = null;
        for( Azione actio : this.azioni) {
        	if(actio.getIndice() <= livelloImpressionabilita.getGradoDurezza() && action == null) {
        		action = actio;
        	}
        }
        if(scen == null) {
        	throw new NoSuchTaleException("Non esistono scenari con il grado di complessità richiesto");
        }
        
        if(action == null) {
        	throw new NoSuchTaleException("Non esistono azioni con il grado di durezza richiesto");
        }
        
        Esordio eso = new Esordio(buoni, cattivi);
        
        return new Favola(eso, scen, action, sorteggia(this.conclusioni));
    }

    private <T> T sorteggia(List<T> lista) {
        return this.sorteggia(lista, lista.size() - 1);
    }

    private <T> T sorteggia(List<T> lista, int upperbound) {
        if(lista.isEmpty()) {
            return null;
        }
        int index = random.nextInt(upperbound);
        return lista.get(index);
    }

    public MySintetizzatore(List<Personaggio> personaggi, List<Scenario> scenari,List<Azione> azioni, List<Conclusione> conclusioni) {
        this.azioni = azioni;
        this.conclusioni = conclusioni;
        this.personaggi = personaggi;
        this.scenari = scenari;
        this.random = new Random();
    }

    
    
}
