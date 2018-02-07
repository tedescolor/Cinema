
/**
 * Rappresenta un'eccezione nel caso lo spettatore in questione non sia desiderato. E' composto da una string con messaggio: "Errore: il cliente non è ammesso a questo spettacolo.\n";
 * @author lorenzo
 *
 */
public class EccezioneSpettatoreIndesiderato extends Exception {
	String message;

	/**
	 * Crea un'istanza con messaggio di default
	 */
	public EccezioneSpettatoreIndesiderato() {
		super();
		message = "Errore: il cliente non è ammesso a questo spettacolo.\n";
	}
	
	

}
