import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EseguibileAmministratoreCinema {

	public static void main(String[] args) {
		double prezzoBiglietto;
		String nomeCinema;
		Cinema cinema;
		Set<String> filmDisponibili;
		Scanner in = new Scanner(System.in);
		Tempo ora = new Tempo(false, false);
		String nomeSala, nomeFilm, genere;
		Boolean adattaMinori;
		int sceltaMenu;
		String result;
		Spettatore spettatoreCorrente = new Spettatore("Empty", "Empty", false);
		int tipoSpettatore;
		System.out.println("Inserisci il nome del tuo cinema.");
		nomeCinema = in.nextLine();
		System.out.println("Inserisci il prezzo del biglietto.");
		prezzoBiglietto = in.nextDouble();

		cinema = new Cinema(nomeCinema, prezzoBiglietto);
		System.out.println("il tuo cinema " + cinema.getName() + " è stato creato correttamente");

		do {
			System.out.println(
					"Prossima operazione:\n1. Aggiungi sala\n2. Modifica film in proiezione\n3. Lista Sale\n4. Lista film ora al cinema\n5. Vendi bilietto\n6. Cambia Ora\n7. Pubblica Statistica Cinema\n8. Svuota Sala\n-1. Esci");
			sceltaMenu = in.nextInt();

			switch (sceltaMenu) {
			case 1:
				in.nextLine();
				System.out.println("Digita il nome della sala");
				nomeSala = in.nextLine();
				System.out.println("Digita la capienza della sala");
				int capienzaSala = in.nextInt();
				try {
					cinema.aggiungSala(new SalaCinematografica(nomeSala, capienzaSala));
					System.out.println("La sala " + nomeSala + " è stata aggiunta correttamente");
				} catch (EccezioneSalaEsistente e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.message);
				}
				break;
			case 2:
				in.nextLine();
				System.out.println("Digita il nome della sala di cui si vuole cambiare il film in proiezione");
				nomeSala = in.nextLine();
				System.out.println("Digita il nome del film");
				nomeFilm = in.nextLine();
				System.out.println("Digita la descrizione del film");
				genere = in.nextLine();
				System.out.println("E' adatto ai minori? true/false");
				adattaMinori = in.nextBoolean();

				if (cinema.haSalaDiNome(nomeSala))
					try {

						cinema.listaSale.get(cinema.indiceSalaDiNome(nomeSala))
								.FilmInProgramma(new Film(adattaMinori, nomeFilm, genere));
					} catch (EccezioneCambioFilm e) {
						// TODO Auto-generated catch block
						System.out.println(e.message);
					}
				else
					System.out.println(cinema.getName() + " non ha la sala con tale nome");
				break;
			case 3:
				System.out.println(cinema.listaSaleToString());
				break;
			case 4:
				filmDisponibili = new HashSet<String>();
				for (SalaCinematografica sala : cinema.listaSale) {
					filmDisponibili.add(sala.filmInProgramma().getTitolo());
				}
				result = "";
				for (String film : filmDisponibili) {
					result = result + film;
					result = result + "\tSale disponibili:";
					for (SalaCinematografica sala : cinema.listaSale) {
						if (sala.filmInProgramma().getTitolo().equals(film))
							result += " " + sala.getNome();
					}
					result += "\n";
				}
				System.out.println(result);
				break;
			case 5:
				if (cinema.listaSale.size() > 0) {
					in.nextLine();
					System.out.println("Digita nome Spettatore");
					String nomeSpetattore = in.nextLine();
					System.out.println("Digita Cognome Spettatore");
					String cognomeSpetattore = in.nextLine();
					System.out.println("Digita età Spettatore");
					int etaSpettatore = in.nextInt();
					boolean isMinore = etaSpettatore < 18;
					do {
						System.out.println(
								"Che Spettatore è?\n1. Spettatore normale\n2. Spettatore Abbonato\n3. Spettatore Anziano");
						tipoSpettatore = in.nextInt();

						switch (tipoSpettatore) {
						case 1:
							spettatoreCorrente = new Spettatore(nomeSpetattore, cognomeSpetattore, isMinore);
							break;
						case 2:
							spettatoreCorrente = new SpettatoreAbbonato(nomeSpetattore, cognomeSpetattore, isMinore);
							break;
						case 3:
							spettatoreCorrente = new SpettatoreAnziano(nomeSpetattore, cognomeSpetattore, isMinore);
							break;
						default:
							System.out.println("Errore nella digitazione");
							tipoSpettatore = -1;
							break;
						}
					} while (tipoSpettatore == -1);

					do {
						in.hasNextLine();
						System.out.println("Nome sala del film?");
						System.out.println(cinema.listaSaleToString());
						nomeSala = in.nextLine();
					} while (!cinema.haSalaDiNome(nomeSala));

					try {
						cinema.listaSale.get(cinema.indiceSalaDiNome(nomeSala)).aggiungiSpettatore(spettatoreCorrente);
						System.out.println("Operazione eseguita correttamente. Prezzo = "
								+ Double.toString(spettatoreCorrente.prezzo(cinema.getPrezzoBiglietto(), ora)));
					} catch (EccezioneSalaPiena e) {
						// TODO Auto-generated catch block
						System.out.println(e.message);
					} catch (EccezioneSpettatoreIndesiderato e) {
						// TODO Auto-generated catch block
						System.out.println(e.message);
					}
				} else
					System.out.println("Errore: il cinema non ha sale");
				break;
			case 6:
				System.out.println("WeekEnd? true/false");
				boolean weekEnd = in.nextBoolean();
				System.out.println("Sera? true/false");
				boolean sera = in.nextBoolean();
				ora = new Tempo(weekEnd, sera);
				break;
			case 7:
				System.out.println(new Statistica(cinema).toString());
				break;
			case 8:
				in.nextLine();
				System.out.println("Digita il nome della sala di cui si vuole cambiare il film in proiezione");
				nomeSala = in.nextLine();
				if (cinema.haSalaDiNome(nomeSala))
					cinema.listaSale.get(cinema.indiceSalaDiNome(nomeSala)).svuotaSala();
				else
					System.out.println(cinema.getName() + " non ha la sala con tale nome");
				break;

			case -1:
				System.out.println("Ciao.");
				break;
			default:
				System.out.println("Errore nella scelta");
				break;

			}
		} while (sceltaMenu != -1);

	}

}
