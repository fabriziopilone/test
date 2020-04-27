
public class Macchina {
	private String tipoAuto;
	private String tipoCarburante;
	private String targa;
	
	public Macchina (String tipoAuto, String tipoCarburante, String targa) {
		this.tipoAuto = tipoAuto;
		this.tipoCarburante = tipoCarburante;
		this.targa = targa;
	}
	public Macchina () {
		
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
	public boolean equals (Macchina auto) {
		if (this.tipoAuto.equals(auto.getTipoAuto()) && this.tipoCarburante.equals(auto.getTipoCarburante())
				&& this.targa.contentEquals(auto.getTarga())) 
			return true;
		else return false;
	}
	public String toString() {
		return "Targa: " +targa +" | Carburante: " +tipoCarburante + " | Tipo auto: " +tipoCarburante +"\n";
	}
}
