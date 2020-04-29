/**
 * classe che modella una automobile solo attraverso tipo del carburante, tipo dell'auto e targa
 * @author Fabrizio Pilone
 * @versione 1.0
 */
public class Macchina {
	private String tipoAuto;
	private String tipoCarburante;
	private String targa;
/**
 * costruttore con tutti i parametri
 * @param tipoAuto tipo dell'auto
 * @param tipoCarburante tipo del carburante
 * @param targa targa dell'auto
 */
	public Macchina (String tipoAuto, String tipoCarburante, String targa) {
		this.tipoAuto = tipoAuto;
		this.tipoCarburante = tipoCarburante;
		this.targa = targa;
	}
/**
 * costruttore senza parametri, imposta tutto a null
 */
	public Macchina () {
		this.tipoAuto = null;
		this.tipoCarburante = null;
		this.targa = null;
	}
	
	public String getTipoAuto() {
		return tipoAuto;
	}
	public void setTipoAuto(String tipoAuto) {
		this.tipoAuto = tipoAuto;
	}
	public String getTipoCarburante() {
		return tipoCarburante;
	}
	public void setTipoCarburante(String tipoCarburante) {
		this.tipoCarburante = tipoCarburante;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getTarga() {
		return targa;
	}
/**
 * controlla se due auto sono uguali
 * @param auto auto da confrontare con quella da cui richiamo il metodo
 * @return true se le due auto sono uguali, false altrimenti
 */
	public boolean equals (Macchina auto) {
		if (this.tipoAuto.equals(auto.getTipoAuto()) && this.tipoCarburante.equals(auto.getTipoCarburante())
				&& this.targa.contentEquals(auto.getTarga())) 
			return true;
		else return false;
	}
/**
 * stampa i parametri dell'automobile
 */
	public String toString() {
		return "Targa: " +targa +" | Carburante: " +tipoCarburante + " | Tipo auto: " +tipoCarburante +"\n";
	}
}
