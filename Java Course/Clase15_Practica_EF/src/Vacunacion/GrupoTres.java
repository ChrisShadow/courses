package Vacunacion;

public class GrupoTres extends Vacuna {
	//ASTRAZENECA ó HAYAT VAX
	private String numero_lote; //sub
	
	
	
	
	public GrupoTres() {
		super();
	}

	public GrupoTres(int dosis, String documento, String lugar_vacunacion, String fecha_aplicacion, TipoVacuna vacuna,
			String fecha_hora_carga,String numero_lote) {
		super(dosis, documento, lugar_vacunacion, fecha_aplicacion, vacuna, fecha_hora_carga);
		this.numero_lote=numero_lote;
	}

	public GrupoTres(int dosis, String documento) {
		super(dosis, documento);
	}

	public GrupoTres(int dosis, TipoVacuna vacuna) {
		super(dosis, vacuna);
	}

	public String getNumero_lote() {
		return numero_lote;
	}

	public void setNumero_lote(String numero_lote) {
		this.numero_lote = numero_lote;
	}
	
	
	@Override
	public String toString() {
		return  "\nDatos generales de la vacuna: " + this.getVacuna().name() + "\n" +super.toString() + "Nro. Lote: " + getNumero_lote()+"\n";
	}

	@Override
	public String Linea() {
		return super.Linea();
	}
}
