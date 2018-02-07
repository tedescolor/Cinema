
/**
 * Questa classe rappresenta un istante di tempo. Contiene dunque due booleani come attributi che indicano se l'istante presente sia nel weekend e sia sia sera
 * @author lorenzo
 *
 */
public class Tempo {
	private boolean weekend;
	private boolean sera;
	/**
	 * Crea un'istanza di tempo
	 * @param weekend booleano che indica se sia o meno weekend
	 * @param sera booleano che indica se sia o meno sera
	 */
	public Tempo(boolean weekend, boolean sera) {
		super();
		this.weekend = weekend;
		this.sera = sera;
	}
	/**
	 * Verifica se sia o meno weekend
	 * @return booleano che indica se sia o meno weekend
	 */
	public boolean isWeekend() {
		return weekend;
	}
	/**
	 * Setta il valore del weekend
	 * @param weekend booleano che indica se sia o meno weekend
	 */
	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}
	/**
	 * verifica se sia o meno sera
	 * @return booleano che indica se sia o meno dela
	 */
	public boolean isSera() {
		return sera;
	}
	/**
	 * setta il valore booleano di sera
	 * @param sera booleano che diventerà il valore di sera
	 */
	public void setSera(boolean sera) {
		this.sera = sera;
	}
	
	/**
	 * verifica se almeno un delle due condizioni tra sera o weekend sia soddisfatta
	 * @return risultato della valutazione
	 */
	public boolean isWeekendOSera() {
		return weekend || sera;
	}
	
}
