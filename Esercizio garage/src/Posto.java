import java.util.Date;

public class Posto {
	private String tipoPosto;
	private Date dataArrivo;
	private int numeroPosto;
	private Macchina macchina;
	private boolean affittato;
	
	public Posto() {
		dataArrivo = new Date();
		macchina = new Macchina();
		affittato = false;
	}
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
