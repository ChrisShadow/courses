package Vacunacion;

public class Vacuna {
	protected int dosis; 
	protected String documento;
	protected String lugar_vacunacion;
	protected String fecha_aplicacion;
	protected TipoVacuna vacuna;
	protected String fecha_hora_carga;
	
	//
	public Vacuna() {
		
	}

	public Vacuna(int dosis, String documento, String lugar_vacunacion, String fecha_aplicacion, TipoVacuna vacuna,
			String fecha_hora_carga) {
		this.dosis = dosis;
		this.documento = documento;
		this.lugar_vacunacion = lugar_vacunacion;
		this.fecha_aplicacion = fecha_aplicacion;
		this.vacuna = vacuna;
		this.fecha_hora_carga = fecha_hora_carga;
	}
	

	public Vacuna(int dosis, String documento) {
		this.dosis = dosis;
		this.documento = documento;
	}

	//Para eliminar y actualizar
	public Vacuna(int dosis, TipoVacuna vacuna) {
		this.dosis = dosis;
		this.vacuna = vacuna;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getLugar_vacunacion() {
		return lugar_vacunacion;
	}

	public void setLugar_vacunacion(String lugar_vacunacion) {
		this.lugar_vacunacion = lugar_vacunacion;
	}

	public String getFecha_aplicacion() {
		return fecha_aplicacion;
	}

	public void setFecha_aplicacion(String fecha_aplicacion) {
		this.fecha_aplicacion = fecha_aplicacion;
	}

	public TipoVacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(TipoVacuna vacuna) {
		this.vacuna = vacuna;
	}

	public String getFecha_hora_carga() {
		return fecha_hora_carga;
	}

	public void setFecha_hora_carga(String fecha_hora_carga) {
		this.fecha_hora_carga = fecha_hora_carga;
	}

	@Override
	public String toString() {
		return "\nNro. Dosis: " + getDosis() + "\nNro. Documento: " + getDocumento() + "\nLugar de vacunación: "
				+ getLugar_vacunacion() + "\nFecha de aplicación: " + getFecha_aplicacion() + "\nFecha de carga: " + getFecha_hora_carga() + "\n";
	}
	
	public String Linea() {
		return   getDocumento() + "     ;     " + getLugar_vacunacion() + "     ;     " + getFecha_aplicacion()+ "     ;     " + getVacuna().name() + "     ;     " + getDosis() + "     ;      "  + getFecha_hora_carga();
	}
	
	
	
	
	
	
}
