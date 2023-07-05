package AlquilerBici;

public class BiciCarrera extends Bici{
	private double peso;
	private int cantMaxRevo;
	private double cantKm;
	
	//
	public BiciCarrera() {
		super();
	}

	public BiciCarrera(String marca, int anho, String serie, int nroAro, double montoAlq, int tipo,double peso, int cantMaxRevo,double cantKm) {
		super(marca, anho, serie, nroAro, montoAlq, tipo);
		this.peso=peso;
		this.cantMaxRevo=cantMaxRevo;
		this.cantKm=cantKm;
	}
	
	//
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getCantMaxRevo() {
		return cantMaxRevo;
	}

	public void setCantMaxRevo(int cantMaxRevo) {
		this.cantMaxRevo = cantMaxRevo;
	}

	public double getCantKm() {
		return cantKm;
	}

	public void setCantKm(double cantKm) {
		this.cantKm = cantKm;
	}
	
}
