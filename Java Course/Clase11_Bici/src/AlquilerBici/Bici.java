package AlquilerBici;

public class Bici {
	protected String marca;
	protected int anho;
	protected String serie;
	protected int nroAro;
	protected double montoAlq;
	protected int tipo;
	
	//
	public Bici() {
	
	}

	public Bici(String marca, int anho, String serie, int nroAro, double montoAlq, int tipo) {
		this.marca = marca;
		this.anho = anho;
		this.serie = serie;
		this.nroAro = nroAro;
		this.montoAlq = montoAlq;
		this.tipo = tipo;
	}

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getNroAro() {
		return nroAro;
	}

	public void setNroAro(int nroAro) {
		this.nroAro = nroAro;
	}

	public double getMontoAlq() {
		return montoAlq;
	}

	public void setMontoAlq(double montoAlq) {
		this.montoAlq = montoAlq;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return  getTipo()  + "\t\t" + getMarca()  + "\t\t" + getAnho() + "\t\t" + getSerie() + "\n";
	}
}
