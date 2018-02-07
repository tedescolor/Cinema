
/**
 * Questa è una sottoclasse di Spettatore. Uno spettatore anziano è uno spettatore che non paga niente durante i giorni feriali, e paga il 50% del biglietto durante il
weekend.
 * @author lorenzo
 *
 */
public class SpettatoreAnziano extends Spettatore{
	/**
	 * crea un'istanza di spettatore con dato nome cognome e booleano di maggiore eta
	 * @param nome nome dello spettatore
	 * @param cognome cognome dello spetattatore
	 * @param minorenne booleano maggiore eta
	 */
	public SpettatoreAnziano(String nome, String cognome, boolean minorenne) {
		super(nome, cognome, minorenne);
		this.tipo = "anziano";
	}

	/**
	 * Calcola il prezzo considerando il fatto che si tratta di un anziano
	 */
	@Override
	public void setPrezzoBigliettoCorrente(double bigliettoStandard, Tempo tempo) {
		if(tempo.isWeekend())
			prezzoBigliettoCorrente = bigliettoStandard * 50 / 100;
		else 
			prezzoBigliettoCorrente = 0;
	}
}
