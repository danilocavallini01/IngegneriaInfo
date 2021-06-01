package favoliere.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import favoliere.model.Personaggio;
import favoliere.model.Tipologia;

public class PersonaggiLoader implements SectionLoader<Personaggio> {

    private List<Personaggio> entities;

    @Override
    public List<Personaggio> getItems() {
        return entities;
    }

    @Override
    public void loadAllItems(Reader baseReader) throws IOException, BadFileFormatException {
        BufferedReader br = new BufferedReader(baseReader);
        String line,tipo,nome,descrizione;
        Tipologia tipologia;

        while((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line,":");


            tipo = st.nextToken().trim();

            if(tipo.isBlank()) {
                throw new BadFileFormatException("tipologia vuota");
            }

            try {
                tipologia = Tipologia.valueOf(tipo);
            } catch (IllegalArgumentException e ) {
                throw new BadFileFormatException("tipologia inesistente");
            }

            nome = st.nextToken().trim();
            if(nome.isBlank()) {
                throw new BadFileFormatException("nome vuoto");
            }

            descrizione = st.nextToken().trim();
            if(descrizione.isBlank()) {
                throw new BadFileFormatException("descrizione vuota");
            }

            this.entities.add(new Personaggio(nome, tipologia, descrizione));
        }
        
    }

    public PersonaggiLoader() {
        this.entities = new ArrayList<Personaggio>();
    }

    
    
}
