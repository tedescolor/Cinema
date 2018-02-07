

/**
 * Questa classe rappresenta una eccezione qualora si voglia aggiungere una sala ad un cinema il cui nome è gia esistente. è costituito da un 
 * Stringa :"Errore: La sala è gia esistente";
 * @author lorenzo
 *
 */
public class EccezioneSalaEsistente extends Exception{
	String message;

	/**
	 * crea una istanza 
	 */
	public EccezioneSalaEsistente() {
		super();
		message = "Errore: La sala è gia esistente";
	}
	
	

}
