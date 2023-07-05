package Vacunacion;

public class GrupoUno extends Vacuna {
	// COVAXIN ó PFIZER
	private Character  es_donada; //sub
	
	
	public GrupoUno() {
		super();
	}

	public GrupoUno(int dosis, String documento, String lugar_vacunacion, String fecha_aplicacion, TipoVacuna vacuna,
			String fecha_hora_carga, char es_donada) {
		super(dosis, documento, lugar_vacunacion, fecha_aplicacion, vacuna, fecha_hora_carga);
		this.es_donada=es_donada;
		}

	public GrupoUno(int dosis, String documento) {
		super(dosis, documento);
	}

	public GrupoUno(int dosis, TipoVacuna vacuna) {
		super(dosis, vacuna);
	}

	public Character getEs_donada() {
		return es_donada;
	}

	public void setEs_donada(char es_donada) {
		this.es_donada = es_donada;
	}

	@Override
	public String toString() {
		return  "\nDatos generales de la vacuna: " + this.getVacuna().name() + "\n" +super.toString() + "¿Es donada?: " + getEs_donada()+"\n" ;
	}

	@Override
	public String Linea() {
		return super.Linea();
	}

	
	
	
}
