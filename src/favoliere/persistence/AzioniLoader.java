package favoliere.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import favoliere.model.Azione;

public class AzioniLoader implements SectionLoader<Azione> {

    private List<Azione> entities;

    @Override
    public List<Azione> getItems() {
        return entities;
    }

    @Override
    public void loadAllItems(Reader baseReader) throws IOException, BadFileFormatException {
        BufferedReader br = new BufferedReader(baseReader);
        String line,descrizione,durez;
        int durezza;

        while((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line,"#");
            
            if(!st.hasMoreTokens()) {
                throw new BadFileFormatException("indice vuoto");
            }
            descrizione = st.nextToken().trim();
            if(descrizione.isBlank()) {
                throw new BadFileFormatException("descrizione vuota");
            }


            if(!st.hasMoreTokens()) {
                throw new BadFileFormatException("indice vuoto");
            }
            durez = st.nextToken().trim();
            try {
                durezza = Integer.parseInt(durez);
            } catch (NumberFormatException e ) {
                throw new BadFileFormatException("indice non numerico");
            }

            this.entities.add(new Azione(descrizione, durezza));
        }
        
    }

    public AzioniLoader() {
        this.entities = new ArrayList<Azione>();
    }
}
