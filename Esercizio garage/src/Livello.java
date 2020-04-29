import java.util.HashMap;
import java.util.Date;
import java.util.Iterator;

/**
 * classe che definisce un livello di un garage
 * @author Fabrizio
 * @version 1.0
 * @see Posto
 * @see Macchina
 */

public class Livello {
	private int numeroPostiNormali;
	private int numeroPostiLusso;
	private int numeroPostiGrandi;
/**
 * HashMap con chiave numero del posto, e valore dato dal posto
 */
	HashMap<Integer, Posto> posti;
	
/**
 * costruttore senza parametri, crea l'HashMap posti
 */
	public Livello () {
		posti = new HashMap<Integer, Posto>();
	}

	public int getNumeroPostiNormali() {
		return numeroPostiNormali;
	}

	public void setNumeroPostiNormali(int numeroPostiNormali) {
		this.numeroPostiNormali = numeroPostiNormali;
	}

	public int getNumeroPostiLusso() {
		return numeroPostiLusso;
	}

	public void setNumeroPostiLusso(int numeroPostiLusso) {
		this.numeroPostiLusso = numeroPostiLusso;
	}

	public int getNumeroPostiGrandi() {
		return numeroPostiGrandi;
	}

	public void setNumeroPostiGrandi(int numeroPostiGrandi) {
		this.numeroPostiGrandi = numeroPostiGrandi;
	}
/**
 * scorre tutti i posti occupati del tipo uguale a quello dell'auto, se sono minori del numero totale di
 * posti di quel tipo restituisce il numero di posto in cui inserire la nuova auto, altrimenti 0
 * @param auto automobile da parcheggiare
 * @return restutisce il numero del posto se c'è ancora posto nel livello per un tipo di automobile
 */
	private int controlloCapacità(String tipoPosto) {	
		int cont=0;
		if (!posti.isEmpty()) {
			Posto posto = new Posto();
			Iterator<Posto> it = posti.values().iterator();
			while (it.hasNext()) {
				posto = it.next();
				if (posto.getTipoPosto().equals(tipoPosto)) cont++;
			}
			
		switch (tipoPosto) {
			case "Normale":
			case "NORMALE":
			case "normale" :{
				if (cont < numeroPostiNormali) return posto.getNumeroPosto()+1;
				else return 0;
			}
			
			case "Lusso":
			case "LUSSO":
			case "lusso" :{
				if (cont < numeroPostiLusso) return posto.getNumeroPosto()+1;
				else return 0;
			}
				
			case "Grande":
			case "GRANDE":
			case "grande" :{
				if (cont < numeroPostiLusso) return posto.getNumeroPosto()+1;
				else return 0;
			}
			default : return 0;
		}
		}
		else return 1;
	}
/**
 * funzione che prende in ingresso il valore restituito da controlloCapacità e lo interpreta come posto
 * in cui parcheggiare, se uguale 0 stampa che non c'è posto
 * @param auto auto da parcheggiare
 * @return true se ha parcheggiato, false altrimenti
 */
	public boolean assegnaPosto(Macchina auto) {
		int pos = controlloCapacità(auto.getTipoAuto());
		if (pos != 0) {
			Posto posto = new Posto(pos, auto.getTipoAuto());
			Date data = new Date();
			posto.setDataArrivo(data);
			posto.setMacchina(auto);
			posti.put(pos, posto);
			return true;
		}
		System.out.println ("Non c'è più posto per la macchina\n" +auto);
		return false;
	}
	
	public void stampa() {
		Iterator<Posto> it_posti = posti.values().iterator();
		while (it_posti.hasNext()) {
			Posto posto = it_posti.next();
			System.out.println ("Posto " + posto.getNumeroPosto() +"Tipo: " +posto.getTipoPosto()
					+"--> Macchina con targa: "  +posto.getMacchina().getTarga());
		}
	}
/**
 * scorre tutti i posti contando il numero di posti affittati per il tipo richiesto, verificando se sono
 * meno del 50% del totale
 * @param tipoPosto tipo del posto da affittare
 * @return true se i posti affittati di quel tipo sono meno del 50% del numero di posti totali di quel tipo
 * false altrimenti
 */
	private boolean controlloAffitti(String tipoPosto) {
		int cont=0;
		if (!posti.isEmpty()) {
			Posto posto = new Posto();
			Iterator<Posto> it = posti.values().iterator();
			while (it.hasNext()) {
				posto = it.next();
				if (posto.getTipoPosto().equals(tipoPosto) && posto.getAffittato()) cont++;
			}
			
		switch (tipoPosto) {
			case "Normale":
			case "NORMALE":
			case "normale" :{
				if (cont < (numeroPostiNormali/2)) return true;
				else return false;
			}
			
			case "Lusso":
			case "LUSSO":
			case "lusso" :{
				if (cont < numeroPostiLusso/2) return true;
				return false;
			}
				
			case "Grande":
			case "GRANDE":
			case "grande" :{
				if (cont < numeroPostiLusso/2) return true;
				return false;
			}
			default : return false;
		}
		}
		else return false;
	}
/**
 * se controlloCapacità e controlloAffitti danno esito positivo affitta il posto indicato da 
 * controlloCapacità, altrimenti distingue i due casi in cui non ci sono posti da affittare o i posti
 * sono momentaneamente occupati da macchine parcheggiate (che quindi si libereranno tra poco)
 * @param tipoPosto tipo del posto da affittare
 * @return numero del posto se si può affittare, 1 se ci sono posti da affittare ma sono momentaneamente 
 * occupati, 0 se non ci sono posti da affittare
 */
	public int affittaPosto (String tipoPosto) {
		boolean affitti = controlloAffitti(tipoPosto);
		int pos = controlloCapacità(tipoPosto);
		if (affitti && pos != 0) {  //ci sono posti da affittare liberi
			Posto posto = new Posto(pos, tipoPosto);
			posto.setAffittato(true);
			posti.put(pos, posto);
			return posto.getNumeroPosto();
		}
		else if (affitti && pos == 0) {	 //ci sono posti da affittare ma sono momentaneamente occupati
			return 1;
		}
		else return 0; 	// caso rimanente, sono finiti i posti da affittare
		
	}
	
}
