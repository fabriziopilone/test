import java.util.Date;
/**
 * classe che modella il posto di un garage
 * @author Fabrizio
 * @version 1.0
 * @see Macchina
 * @see java.util.Date
 */
public class Posto {
	private String tipoPosto;
	private Date dataArrivo;
	private int numeroPosto;
	/**
	 * macchina presente nel posto
	 */
	private Macchina macchina;
	/**
	 * segnala se il posto è stato affittato o se è occupato da un'auto parcheggiata
	 */
	private boolean affittato;
/**
 * costruttore senza parametri, inizializza l'ora di arrivo e la macchina
 */
	public Posto() {
		dataArrivo = new Date();
		macchina = new Macchina();
		affittato = false;
	}
/**
 * costruttore con due parametri
 * @param numeroPosto numero del posto da creare
 * @param tipoPosto tipo del posto
 */
	public Posto (int numeroPosto, String tipoPosto) {
		this.numeroPosto = numeroPosto;
		this.tipoPosto = tipoPosto;
		dataArrivo = new Date();
		macchina = new Macchina();
		affittato = false;
	}
	
	public String getTipoPosto() {
		return tipoPosto;
	}
	public void setTipoPosto(String tipoPosto) {
		this.tipoPosto = tipoPosto;
	}
	public Date getOraArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public int getNumeroPosto() {
		return numeroPosto;
	}
	public void setMacchina(Macchina auto) {
		this.macchina = auto;
	}
	public Macchina getMacchina() {
		return macchina;
	}
	public boolean getAffittato() {
		return affittato;
	}
	public void setAffittato(boolean affittato) {
		this.affittato = affittato;
	}
}
