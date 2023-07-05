package Vacunacion;

public class GrupoDos extends Vacuna {
	//MODERNA ó SPUTNIK V
	private int costo_vacuna; //sub 
	
	
	public GrupoDos() {
		super();
	}

	public GrupoDos(int dosis, String documento, String lugar_vacunacion, String fecha_aplicacion, TipoVacuna vacuna,
			String fecha_hora_carga, int costo_vacuna) {
		super(dosis, documento, lugar_vacunacion, fecha_aplicacion, vacuna, fecha_hora_carga);
		this.costo_vacuna= costo_vacuna;
	}

	public GrupoDos(int dosis, String documento) {
		super(dosis, documento);
	}

	public GrupoDos(int dosis, TipoVacuna vacuna) {
		super(dosis, vacuna);
	}

	public int getCosto_vacuna() {
		return costo_vacuna;
	}

	public void setCosto_vacuna(int costo_vacuna) {
		this.costo_vacuna = costo_vacuna;
	}
	
	
	
	@Override
	public String toString() {
		return  "\nDatos generales de la vacuna: " + this.getVacuna().name() + "\n" +super.toString() + "Costo: " + getCosto_vacuna()+"\n";
	}

	@Override
	public String Linea() {
		return super.Linea();
	}
}
