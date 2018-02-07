import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Questa classe rappresenta una statistica. Fornisce quindi dettagli statistici riguardti gli spetattori
 * @author lorenzo
 *
 */
/**
 * @author lorenzo
 *
 */
public class Statistica {
	
	public static ArrayList<String> listaTipi = new ArrayList<String>();
	
	private  Map<String, Integer> mappa;
	private double incassoTotale;
	private double incassoMedioSpettatore;
	
	static {
		listaTipi.add("classico");
		listaTipi.add("abbonato");
		listaTipi.add("anziano");
		listaTipi.add("minorenne");
	}
	



	/**
	 * crea una statistica vuota
	 */
	public Statistica() {
		
			mappa = new HashMap<String,Integer>();
		for(String tipo : listaTipi)
			mappa.put(tipo, 0);
		incassoMedioSpettatore = 0;
		incassoTotale = 0;
		
		
		
	}
	
	/**
	 * Crea una statistica a partire da un cinema
	 * @param cinema cinema di cui si vuole la statistica
	 */
	public Statistica (Cinema cinema) {
		this();
		for(SalaCinematografica sala : cinema.listaSale) {
			this.sommaStatistica(new Statistica(sala));
		}
		incassoMedioSpettatore = incassoTotale / this.numeroTotaleSpettatori();
	}
	
	/**
	 * Crea una statistica di una data sala
	 * @param sala sala di cui si vuole la statistica
	 */
	public Statistica(SalaCinematografica sala) {
		
		this();
		
		
		for (Spettatore spettatore : sala.listaSpettatori) {
			mappa.put(spettatore.tipo, mappa.get(spettatore.tipo)+1);
			incassoTotale += spettatore.prezzoBigliettoCorrente;
			if(spettatore.isMinorenne())
				mappa.put("minorenne", mappa.get("minorenne")+1);
		}
		
		incassoMedioSpettatore = incassoTotale / this.numeroTotaleSpettatori();
	
	}
	
	
	
	/**
	 * crea la statistica di un dato film in un dato cinema
	 * @param cinema cinema in question
	 * @param film film in questione
	 */
	public Statistica(Cinema cinema, Film film) {
		for(SalaCinematografica sala : cinema.listaSale) {
			if(sala.filmInProgramma().getTitolo() == film.getTitolo())
				this.sommaStatistica(new Statistica(sala));
		}
		
		incassoMedioSpettatore = incassoTotale / this.numeroTotaleSpettatori();
	}
	
	/**
	 * Crea una statistica di un genre di film in un dato cinema
	 * @param cinema cinema in questione
	 * @param genere genere in question
	 */
	public Statistica(Cinema cinema, String genere) {
		
		for(SalaCinematografica sala : cinema.listaSale) {
			if(sala.filmInProgramma().getGenere() == genere)
				this.sommaStatistica(new Statistica(sala));
		}
		incassoMedioSpettatore = incassoTotale / this.numeroTotaleSpettatori();
	}
	
	/**
	 * Somma tra loro delle statistiche. è un metodo privato per facilitare alcuni altri metodi
	 * @param statistica statistica che si vuole sommare a this
	 */
	private void sommaStatistica(Statistica statistica) {
		for(String tipo : listaTipi)
			this.mappa.put(tipo, statistica.mappa.get(tipo) + this.mappa.get(tipo));
		this.incassoTotale = statistica.incassoTotale + this.incassoTotale;
	}
	
	/**
	 * restituisce il numero totale degli speattori
	 * @return numero totale degli speattori
	 */
	public int numeroTotaleSpettatori() {
		int result=0;
		for(String tipo : listaTipi)
			if(!tipo.equals("minorenne"))
				result += mappa.get(tipo);
		return result;
	}
	

/**
 * @return restituisce una stringa che premette di stampare i valori della statistica
 */
	public String toString() {
		String result ="";
		
		for(String tipo : listaTipi) {
			result += tipo + ": " + Integer.toString( mappa.get(tipo) ) + "\n";
		}
		result += "Incasso Totale = " + Double.toString(incassoTotale) + "\n";
		result += "Incasso Medio Spetattore = " + Double.toString(incassoMedioSpettatore) + "\n";
		return result;
	}

	
	/**
	 * Restituisce l'incasso totale della statisticqa
	 * @return incasso totale 
	 */
	public double getIncassoTotale() {
		return incassoTotale;
	}
	
}
