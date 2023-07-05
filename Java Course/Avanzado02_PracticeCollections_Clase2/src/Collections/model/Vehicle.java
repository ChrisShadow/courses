package Collections.model;

public class Vehicle {
	private String matricula;
	private String marca;
	private String tipo;
	private int km;
	
	
	public Vehicle() {
		
	}
	
	public Vehicle(String matricula, String marca, String tipo, int km) {
		this.matricula = matricula;
		this.marca = marca;
		this.tipo = tipo;
		this.km = km;
	}
	

	//
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "\nMatricula()= " + getMatricula() + "\n Marca()= " + getMarca() + "\n Tipo()= " + getTipo()
				+ "\n Km()= " + getKm() + "\n";
	}
	
	
	
	
	
	
}
