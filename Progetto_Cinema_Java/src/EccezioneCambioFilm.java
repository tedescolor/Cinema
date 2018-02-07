
/**
 * Questa classe rappresenta un'eccezione nel caso di cambio di film in una sala dove cè attualmente una proiezione in corso
 * è costituito da un messaggio di errore : "Errore nel cambio del film.\n";
 * @author lorenzo
 *
 */
public class EccezioneCambioFilm extends Exception{
	String message;

	/**
	 * costruisce una eccezione
	 */
	public EccezioneCambioFilm() {
		super();
		this.message = "Errore nel cambio del film.\n";
	}
	
	

}
