
/**
 * Questa classe rappresenta un film
 * @author lorenzo
 *
 */
public class Film {
	private boolean adattoMinori;
	private String titolo;
	private String Genere;
	
	
	/**
	 * Crea un film 
	 * @param adattoMinori indica se il film è adatto ai minori
	 * @param titolo titolo del film
	 * @param genere genere del film
	 */
	public Film(boolean adattoMinori, String titolo, String genere) {
		super();
		this.adattoMinori = adattoMinori;
		this.titolo = titolo;
		Genere = genere;
	}
	/**
	 * @return booleano che indica se il film sia adatto ai minori
	 */
	public boolean isAdattoMinori() {
		return adattoMinori;
	}
	/**
	 * @return restituisce nome del film
	 */
	public String getTitolo() {
		return titolo;
	}
	/**
	 * @return restituisce genere del film
	 */
	public String getGenere() {
		return Genere;
	}

	
	
}
