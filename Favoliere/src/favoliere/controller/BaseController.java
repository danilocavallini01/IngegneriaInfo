package favoliere.controller;

import favoliere.model.Sintetizzatore;
import favoliere.persistence.SectionLoader;

import java.util.List;

import favoliere.model.Azione;
import favoliere.model.Conclusione;
import favoliere.model.FasciaEta;
import favoliere.model.Impressionabilita;
import favoliere.model.MySintetizzatore;
import favoliere.model.Personaggio;
import favoliere.model.Scenario;

public abstract class BaseController implements Controller {

	private String fileNamePersonaggi;
	private String fileNameScenari;
	private String fileNameAzioni;
	private String fileNameConclusioni;
	private String outputFileName;
	private Sintetizzatore sintetizzatore;
			
	public BaseController(SectionLoader<Personaggio> lp, String fileNamePersonaggi, SectionLoader<Scenario> ls, String fileNameScenari, 
			SectionLoader<Azione> la, String fileNameAzioni, SectionLoader<Conclusione> lc, String fileNameConclusioni, String outputFileName) {
		this.outputFileName = outputFileName;
		this.fileNamePersonaggi = fileNamePersonaggi;
		this.fileNameScenari=fileNameScenari;
		this.fileNameAzioni=fileNameAzioni;
		this.fileNameConclusioni=fileNameConclusioni;

		List<Personaggio> personaggi  = load(this.fileNamePersonaggi, lp);
		List<Scenario> 	  scenari 	  = load(this.fileNameScenari, ls);
		List<Azione> 	  azioni  	  = load(this.fileNameAzioni, la);
		List<Conclusione> conclusioni = load(this.fileNameConclusioni, lc);
		
		this.sintetizzatore = new MySintetizzatore(personaggi, scenari, azioni, conclusioni);
	}

	@Override
	public Impressionabilita[] getLivelliImpressionabilita() {
		return Impressionabilita.values();
	}

	@Override
	public FasciaEta[] getFasceEta() {
		return FasciaEta.values();
	}

	@Override
	public String getOutputFileName() {
		return outputFileName;
	}
	
	protected abstract <T> List<T> load(String filename, SectionLoader<T> loader);
	protected Sintetizzatore getSintetizzatore() { return sintetizzatore; }
}
