package AlquilerBici;

public class BiciPaseo extends Bici{
	private int altura;
	private String tipoManubrio;
	private String tipoCadena;
	
	public BiciPaseo() {
		super();
	}

	public BiciPaseo(String marca, int anho, String serie, int nroAro, double montoAlq, int tipo,int altura, String tipoManubrio, String tipoCadena) {
		super(marca, anho, serie,nroAro, montoAlq, tipo);
		this.altura = altura;
		this.tipoManubrio = tipoManubrio;
		this.tipoCadena = tipoCadena;
	}

	//
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getTipoManubrio() {
		return tipoManubrio;
	}

	public void setTipoManubrio(String tipoManubrio) {
		this.tipoManubrio = tipoManubrio;
	}

	public String getTipoCadena() {
		return tipoCadena;
	}

	public void setTipoCadena(String tipoCadena) {
		this.tipoCadena = tipoCadena;
	}
	
	
	
}
