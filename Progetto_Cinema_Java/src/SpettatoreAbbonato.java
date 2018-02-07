
/**
 * Questa è una sottoclasse della classe spettatore. Ciò che cambia è il costo del biglietto : Uno spettatore abbonato è uno spettatore che ha diritto al 30% di sconto su tutti i biglietti.
 * @author lorenzo
 *
 */
public class SpettatoreAbbonato extends Spettatore {

	/**
	 * crea un'istanza di spettatoreAbbonato con dato nome cognome e booleano di maggiore eta
	 * @param nome nome dello spettatore
	 * @param cognome cognome dello spetattatore
	 * @param minorenne booleano maggiore eta
	 */
	public SpettatoreAbbonato(String nome, String cognome, boolean minorenne) {
		super(nome, cognome, minorenne);
		this.tipo = "abbonato";
	}

/**
 * Calcola il prezzo considerando il fatto che si tratta di un abbonato
 */
	@Override
	public void setPrezzoBigliettoCorrente(double bigliettoStandard, Tempo tempo) {
		prezzoBigliettoCorrente = 70 * bigliettoStandard / 100;
	}
	
}
