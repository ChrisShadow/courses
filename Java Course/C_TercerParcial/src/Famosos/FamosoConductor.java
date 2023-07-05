package Famosos;

public class FamosoConductor extends InfoFamosos {
	private double peso;
	private int anhoIniCar;
	private String tipoProg;
	private String[] dist;
	
	//
	public FamosoConductor() {
		super();
	}
	
	public FamosoConductor(String nombreApellido, char sexo, int fechaNac, String keyFamoso, int tipoFam, double peso, 
			int anhoIniCar, String tipoProg, String dist ) {
		super(nombreApellido, sexo, fechaNac, keyFamoso, tipoFam);
		this.peso= peso;
		this.anhoIniCar= anhoIniCar;
		this.tipoProg=tipoProg;
		this.dist = dist.split(",");
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getAnhoIniCar() {
		return anhoIniCar;
	}

	public void setAnhoIniCar(int anhoIniCar) {
		this.anhoIniCar = anhoIniCar;
	}

	public String getTipoProg() {
		return tipoProg;
	}

	public void setTipoProg(String tipoProg) {
		this.tipoProg = tipoProg;
	}

	public String[] getDist() {
		return dist;
	}

	public void setDist(String[] dist) {
		this.dist = dist;
	}
	
	
	
}
