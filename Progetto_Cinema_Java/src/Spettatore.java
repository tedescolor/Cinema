
/**
 * questa classe rappresenta uno spettatore. Esso è fornito di un nome, cognome, un valore booleano che indica si sia o meno minorenne
 * e un tipo, che indica la tipologia di spettatore.
 * @author lorenzo
 *
 */
public class Spettatore {
	private String nome;
	private String cognome;
	boolean minorenne;
	String tipo;
	double prezzoBigliettoCorrente;
	/**
	 * crea un'istanza di spettatore con dato nome cognome e booleano di maggiore eta
	 * @param nome nome dello spettatore
	 * @param cognome cognome dello spetattatore
	 * @param minorenne booleano maggiore eta
	 */
	public Spettatore(String nome, String cognome, boolean minorenne) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.minorenne = minorenne;
		this.tipo = "classico";
	}
	
	
	
	/**
	 * Verifica se lo speattore è maggiorenne
	 * @return stato di maggiore età
	 */
	public boolean isMinorenne() {
		return minorenne;
	}



	

	/**
	 * Restituisce nome dello spetattore
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}



	/**
	 * restituisce cognome dello spettatore
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}


	/**
	 * Restituisce il prezzo del biglietto
	 * @param bigliettoStandard prezzo standard
	 * @param tempo momento in cui si compra il biglietto
	 */
	void setPrezzoBigliettoCorrente(double bigliettoStandard, Tempo tempo) {
		prezzoBigliettoCorrente = bigliettoStandard;
	}
	
	/**
	 * Setta il prezzo dell'ultimo biglietto pagato e lo restituisce. Particolarmente utile per fare statistiche
	 * @param bigliettoStandard prezzo del biglietto stardard
	 * @param tempo momento in cui si è comprato il biglietto
	 * @return restituise il prezzo corrente
	 */
	public double prezzo(double bigliettoStandard, Tempo tempo) {
		this.setPrezzoBigliettoCorrente(bigliettoStandard,tempo);
		return this.prezzoBigliettoCorrente;
	}
	
}
