import java.util.ArrayList;
import java.util.Scanner;

/**
 * Rappresenta una sala cinematografica. Ha quindi come attribuiti un nome, una capienza massima, il film attualmente in sala e una lista di spettatori
 * @author lorenzo
 *
 */
public class SalaCinematografica {
	
		private String nome;
		private int capienza;
		private Film filmInProgramma;
		
		ArrayList<Spettatore> listaSpettatori;
		
		/**
		 * crea una sala cinematografica
		 * @param nome nome della sala
		 * @param capienza capienza della sala
		 */
		public SalaCinematografica(String nome, int capienza) {
			super();
			this.nome = nome;
			this.capienza = capienza;
			listaSpettatori = new ArrayList<Spettatore>();
			filmInProgramma = new Film(false, "NULL", "NULL");
		}

		
		
		

		/**
		 * restituisce il numero di spettatori nella sala
		 * @return numero di speattatori
		 */
		public int spettatoriInSala() {
			return listaSpettatori.size();
		}
		
		/**
		 * Aggiunge uno speattore nella sala qualora fosse possibile
		 * @param spettatore spettatore da aggiungere
		 * @throws EccezioneSalaPiena eccezione nel caso la sala sia piena
		 * @throws EccezioneSpettatoreIndesiderato eccezione nel caso  non sia possibile ammettere lo spettatore
		 */
		public void aggiungiSpettatore(Spettatore spettatore) throws EccezioneSalaPiena, EccezioneSpettatoreIndesiderato{
			if(this.salaPiena())
				throw new EccezioneSalaPiena();
			else if(this.spettatoreDesiderato(spettatore))
				listaSpettatori.add(spettatore);
			
		}
		
		
		/**
		 * verifica la disponibilita di posti
		 * @return booleano che rappresenta la disponibilita di ulteriori posti
		 */
		public boolean salaPiena() {
			return capienza == this.spettatoriInSala();
		}
		
		/**
		 * questo metodo vuota la sala
		 */
		public void svuotaSala() {
			listaSpettatori = new ArrayList<Spettatore>();
		}

		/**
		 * questo metodo verifica che la sala sia vuota
		 * @return booleano che indica se la sala è vuota
		 */
		public boolean salaVuota() {
			return listaSpettatori.size() == 0;
		}
		
		/**
		 * Cambia il film in programma
		 * @param film nuovo film
		 * @throws EccezioneCambioFilm eccezione del caso si voglia cambiare il film mentre la sala non è vuota
		 */
		public void FilmInProgramma(Film film) throws EccezioneCambioFilm{
			if(salaVuota()) {
				this.filmInProgramma = film;
				
			}
			else 
				throw new EccezioneCambioFilm();
		}
		
		/**
		 * restituisce il film in programma al momento
		 * @return film in programma
		 */
		public Film filmInProgramma() {
			return filmInProgramma;
		}
		
		/**
		 * Verifica se lo spettatore sia o meno desiderato in sala solleva un eccezione nel caso lo spettatore non sia desiderato
		 * @param spettatore spettatore di cui si vuole la verifica
		 * @return booleano che indica se sia possibile o meno accetare lo spettatore in questione
		 * @throws EccezioneSpettatoreIndesiderato eccezione nel caso lo spettatore non sia desiderato
		 */
		public boolean spettatoreDesiderato(Spettatore spettatore) throws EccezioneSpettatoreIndesiderato {
			if(spettatore.minorenne && !filmInProgramma.isAdattoMinori())
				throw new EccezioneSpettatoreIndesiderato();
			else
				return true;
						
						
			
		}
		
		
		
		/**
		 * restituisce il nome della sala
		 * @return nome della sala
		 */
		public String getNome() {
			return nome;
		}





		/**
		 * restituisce una stringa contenente dettagli sulla sala
		 * @return stringa contenente dettagli sulla sala
		 */
		public String toString() {
			return this.nome + ": posti liberi " + Integer.toString(capienza-this.spettatoriInSala());
		}
		
}
