
/**
 * Questa classe rappresenta un'eccezione nel caso si voglia aggiungere uno spettatore ma la sala risulti già piena
 * è costituito da un messaggio di errore: "Errore: La sala risulta piena.\n";
 * @author lorenzo
 *
 */
public class EccezioneSalaPiena extends Exception{
	String message;

	public EccezioneSalaPiena() {
		super();
		message = "Errore: La sala risulta piena.\n";
	}
	
	

}
