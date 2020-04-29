import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Date;

/**
 * Classe che definisce un garage e istanzia il numero di livelli desiderato
 * @author Fabrizio Pilone
 * @version 1.0
 * @see Livello
 * @see Macchina
 *
 */

public class Garage {
/**
 * la chiave è il numero di livello, il valore è il livello
 */
	private HashMap<Integer, Livello> livelli;
/**
 * nome del livello
 */
	private String nome;
/**
 * numero di livelli del garage
 */
	private int numeroLivelli;
	Scanner scanner;
	
/**
 * costruttore di garage, chiede il numero di livelli desiderati e istanzia quel numero di livelli passandogli
 * per parametro il numero di posti normali, di lusso e grandi 
 * @param nome nome del garage
 */
	public Garage (String nome) {
		this.nome = nome;
		scanner = new Scanner(System.in);
		livelli = new HashMap<Integer, Livello>();
		System.out.println ("Quanti livelli ha il garage?");
		this.numeroLivelli = scanner.nextInt();
		for (int i=1; i <= numeroLivelli; i++) {
			Livello livello = new Livello();
			System.out.println ("Quanti posti normali ha il livello " +i +" ? ");
			livello.setNumeroPostiNormali(scanner.nextInt());
			System.out.println ("Quanti posti di lusso ha il livello " +i +" ? ");
			livello.setNumeroPostiLusso (scanner.nextInt());
			System.out.println ("Quanti posti grandi ha il livello " +i +" ? ");
			livello.setNumeroPostiGrandi (scanner.nextInt());
			livelli.put(i, livello);
		}
		scanner.close();
	}
/**
 * costruttore con parametri
 * @param nome nome garage
 * @param numeroLivelli numero di livelli del garage
 */
	public Garage (String nome, int numeroLivelli) {
		this.nome = nome;
		this.numeroLivelli = numeroLivelli;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
/**
 * per le auto a gpl prova ad inserirle nel primo livello, le altre prova ad inserirle in ogni livello
 * finchè non ci riesce {@link Livello#assegnaPosto(Macchina)}
 * @param auto
 */
	public void inserisciMacchina (Macchina auto) {
		if (auto.getTipoCarburante().equalsIgnoreCase("gpl")) {
			Livello livello1 = livelli.get(1);
			if(!livello1.assegnaPosto(auto)) 
				System.out.println ("Livello 1 pieno");
		}
		else {
		Iterator <Livello> it = livelli.values().iterator();
		boolean inserito=false;
		do {
			Livello livello = it.next();
			inserito = livello.assegnaPosto(auto);
		}
		while (it.hasNext() && !inserito);
		}
	}
/**
 * ritira l'auto richiesta	
 * @param auto auto da ritirare
 * @return true se l'eliminazione ha buon esito, false altrimenti
 */
	public boolean ritiraMacchina (Macchina auto) {
		Iterator <Livello> it = livelli.values().iterator();
		boolean trovata=false;
		
		do {
			Livello livello = it.next();
			Iterator <Posto> it_posti = livello.posti.values().iterator();
			while (it_posti.hasNext()) {
				Posto posto = it_posti.next();
				if(posto.getMacchina().equals(auto)) {
					Date dataAttuale = new Date();
					if (dataAttuale.getHours() - posto.getOraArrivo().getHours() > 8)
						System.out.println ("Penale per sforamento 8 ore: euro 20");
					it_posti.remove();
					trovata=true;
					return trovata;
				}
			}
		}while(it.hasNext() && !trovata);
		System.out.println ("Macchina non presente");
		return false;
	}
/**
 * stampa tutti i posti presenti nel garage {@link Livello#stampa()}
 */
	public void stampa() {
		for (int i=1; i <= numeroLivelli; i++) {
			System.out.println("Livello " +i +"\n");
			Livello livello = livelli.get(i);
			livello.stampa();
		}
	}
/**
 * affitta un posto del tipo desiderato,ponendo la condizione che le auto a gpl vadano solo nel primo livello
 * utilizzando i metodi {@link Livello#assegnaPosto(Macchina) e {@link Livello#affittaPosto(String)}
 * @param tipoPosto tipo posto da affittare
 * @param tipoCarburante tipo carburante dell'auto che parcheggeremo
 * @return il numero del posto affittato, oppure 0 se non è stato affittato alcun posto
 */
	public int affittaPosto(String tipoPosto, String tipoCarburante) {
		int i=1;
		int risultato;
		int liv=0;
		if (tipoCarburante.equalsIgnoreCase("gpl")) {
			Livello livello = livelli.get(1);
			risultato = livello.affittaPosto(tipoPosto);
			switch (risultato) {
			case '0':{
				System.out.println ("Le auto a gpl posso parcheggiare solo nel primo livello"
						+ " ma i posti da affittare sono termimati.");
				break;
			}
			case '1':{
				System.out.println("Le auto a gpl possono parcheggiare solo nel primo livello"
						+ " ma i posti sono momentaneamente occupati, riprova più tardi");
				break;
			}
			default:{
				System.out.println ("Affittato posto numero: " +risultato +" nel primo livello");
				return risultato;
			}
			}
		}
		else {
			do {
					Livello livello = livelli.get(i);
					risultato = livello.affittaPosto(tipoPosto);
					if (risultato == 1) liv=i;
					i++;
			}while (i <= numeroLivelli && (risultato==0 || risultato==1));
			if (i <= numeroLivelli) {
				System.out.println ("Affittato posto numero: " +risultato +" nel livello" +i);
				return risultato;
			}
			else if (liv != 0) System.out.println ("C'è un posto da affittare nel livello "
					+liv + " ma è attualmente occupato, riprova più tardi");
		}
		return 0;
	}
}
