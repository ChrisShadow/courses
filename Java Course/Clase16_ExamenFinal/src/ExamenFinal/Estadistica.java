package ExamenFinal;

public class Estadistica {
	private String sexo;
	private int departamento;
	private Vacuna vacuna;
	private int dosis;
	private int cantidad;
	
	public Estadistica() {
		
	}

	public Estadistica(String sexo, int departamento, Vacuna vacuna, int dosis, int cantidad) {
		this.sexo = sexo;
		this.departamento = departamento;
		this.vacuna = vacuna;
		this.dosis = dosis;
		this.cantidad = cantidad;
	}

	public Estadistica(String sexo, int departamento, Vacuna vacuna, int dosis) {
		this.sexo = sexo;
		this.departamento = departamento;
		this.vacuna = vacuna;
		this.dosis = dosis;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "\nSexo: " + getSexo() + "\nNro. Dto: " + getDepartamento() + "\nVacuna: "
				+ getVacuna().name() + "\nNro. Dosis: " + getDosis() + "\nCantidad: " + getCantidad() + "\n";
	}
	
	public String Linea() {
		return   getDepartamento() + "     ;     " + getVacuna().name() + "     ;     " + getDosis() + "     ;     " + getCantidad();
	}
	
	
	
}
