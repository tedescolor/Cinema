import java.util.ArrayList;

/**
 * Rappresenta un cinema. Il cinema ha un nome ed è composto da un insieme di
 * sale
 * 
 * @author lorenzo
 *
 */

public class Cinema {

	private String name;
	private double prezzoBiglietto;
	private double incasso;

	public ArrayList<SalaCinematografica> listaSale;

	/**
	 * Crea un cinema di dato nome e prezzo biglietto
	 * 
	 * @param name
	 *            nome del cinema
	 * @param prezzoBiglietto
	 *            prezzo del cinema
	 */
	public Cinema(String name, double prezzoBiglietto) {
		super();
		this.name = name;
		this.prezzoBiglietto = prezzoBiglietto;
		incasso = 0;
		listaSale = new ArrayList<SalaCinematografica>();

	}

	/**
	 * @return nome del cinema
	 */
	public String getName() {
		return name;
	}

	/**
	 * setta il nome del cinema
	 * 
	 * @param name
	 *            nome del cinema
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return prezzo del biglietto
	 */
	public double getPrezzoBiglietto() {
		return prezzoBiglietto;
	}

	/**
	 * setta il prezzo del biglietto
	 * 
	 * @param prezzoBiglietto
	 *            prezzo del biglietto
	 */
	public void setPrezzoBiglietto(double prezzoBiglietto) {
		this.prezzoBiglietto = prezzoBiglietto;
	}

	/**
	 * aggiunge una sala qualora non esistesse
	 * 
	 * @param sala
	 *            sala da aggiungere
	 * @throws EccezioneSalaEsistente
	 *             eccezione del caso la sala esista già
	 */
	void aggiungSala(SalaCinematografica sala) throws EccezioneSalaEsistente {
		boolean check = true;
		for (SalaCinematografica currentSala : listaSale)
			if (currentSala.getNome().equals(sala.getNome()))
				check = false;
		if (!check)
			throw new EccezioneSalaEsistente();
		else
			listaSale.add(sala);
	}

	/**
	 * setta il prezzo del biglietto
	 * 
	 * @param prezzoBiglietto
	 *            prezzo del biglietto
	 */
	void prezzo(double prezzoBiglietto) {
		this.prezzoBiglietto = prezzoBiglietto;
	}

	/**
	 * @return ritorna il prezzo nel caso di weekend o sera
	 */
	double prezzoWeekendOSera() {
		return 125 * prezzoBiglietto / 100;
	}

	/**
	 * Ritorna il prezzo corrente in base al tempo
	 * 
	 * @param tempo
	 *            tempo corrente
	 * @return prezzo corrente
	 */
	double prezzo(Tempo tempo) {
		if (tempo.isWeekendOSera())
			return this.prezzoWeekendOSera();
		else
			return this.prezzoBiglietto;
	}

	/**
	 * @return incasso totale
	 */
	double incassoTotale() {
		return new Statistica(this).getIncassoTotale();
	}

	/**
	 * Restituisce il prezzo da pagare per lo spettatore passato in argomento
	 * 
	 * @param spettatore
	 *            spettatore che vuole comprare il biglietto
	 * @param sala
	 *            sala in cui lo spettatore vorrebbe vedere il film
	 * @param tempo
	 *            momento in cui lo spettatore vuole vedere il film
	 * @return prezzo del biglietto
	 * @throws EccezioneSalaPiena
	 *             eccezione nel caso la sala sia piena
	 * @throws EccezioneSpettatoreIndesiderato
	 *             Eccezione nel caso lo spettatore non possa visionare il film
	 */
	double emettiBiglietto(Spettatore spettatore, SalaCinematografica sala, Tempo tempo)
			throws EccezioneSalaPiena, EccezioneSpettatoreIndesiderato {
		sala.spettatoreDesiderato(spettatore);
		sala.aggiungiSpettatore(spettatore);
		incasso += spettatore.prezzo(this.prezzo(tempo), tempo);
		return spettatore.prezzo(this.prezzoBiglietto, tempo);
	}

	/**
	 * restituisce la statistica del cinema
	 * 
	 * @return statistica del cinema
	 */
	public Statistica calcolaStatistiche() {

		return new Statistica(this);
	}

	/**
	 * restituisce la statistica della sala passata in argomento
	 * 
	 * @param sala
	 *            sala di cui si vuole la statistica
	 * @return statistica della sala
	 */
	public Statistica calcolaStatistiche(SalaCinematografica sala) {
		return new Statistica(sala);
	}

	/**
	 * restituisce la statistica del film passato in argomento
	 * 
	 * @param film
	 *            film di cui si vuole la statistica
	 * @return statistica del film
	 */
	public Statistica calcolaStatistiche(Film film) {
		return new Statistica(this, film);
	}

	/**
	 * Calcola la statistica del genere passato in argomento
	 * 
	 * @param genere
	 *            genere di cui calcolare la statistica
	 * @return statistica del film
	 */
	public Statistica calcolaStatistiche(String genere) {
		return new Statistica(this, genere);
	}

	/**
	 * verifica che il cinema abbia una sala del nome passato in argomento
	 * 
	 * @param nomeSala
	 *            nome della sala di cui si vuole verificare la presenza
	 * @return booleano della verifica
	 */
	public boolean haSalaDiNome(String nomeSala) {
		boolean result = false;
		for (SalaCinematografica sala : listaSale)
			if (sala.getNome().equals(nomeSala))
				result = true;
		return result;
	}

	/**
	 * Restituisce l'indice dalla sala con nome passato in argomento rispetto alla
	 * lista delle sale
	 * 
	 * @param nomeSala
	 *            nome dalla sala di cui si vuole l'indice
	 * @return indice dalla sala
	 */
	public int indiceSalaDiNome(String nomeSala) {
		int result = 0;
		if (this.haSalaDiNome(nomeSala))
			for (SalaCinematografica sala : listaSale) {
				if (sala.getNome().equals(nomeSala))
					return result;
				else
					result++;
			}
		else
			return -1;
		return result;

	}

	/**
	 * Restituisce una stringa contente la lista delle sale del cinema
	 * @return stringa dei nomi delle sale contenute nel cinema
	 */
	public String listaSaleToString() {
		String result = "";
		for (SalaCinematografica sala : this.listaSale) {
			result += sala.toString();
		}
		return result;
	}

}
