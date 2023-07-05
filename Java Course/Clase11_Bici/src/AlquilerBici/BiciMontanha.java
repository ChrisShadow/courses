package AlquilerBici;

public class BiciMontanha extends Bici {
	private double anchura;
	private String resistencia;
	
	public BiciMontanha() {
		super();
	}


	public BiciMontanha(String marca, int anho, String serie, int nroAro, double montoAlq, int tipo,double anchura, String resistencia) {
		super(marca, anho, serie,nroAro, montoAlq, tipo);
		this.anchura = anchura;
		this.resistencia = resistencia;
	}

	//
	public double getAnchura() {
		return anchura;
	}


	public void setAnchura(double anchura) {
		this.anchura = anchura;
	}


	public String getResistencia() {
		return resistencia;
	}


	public void setResistencia(String resistencia) {
		this.resistencia = resistencia;
	}
	
	
	
	
}
