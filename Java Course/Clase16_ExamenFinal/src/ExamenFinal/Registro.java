package ExamenFinal;

public class Registro {
	protected String documento;
	protected int departamento_donde_vive;
	protected String sexo;
	protected Vacuna vacuna;
	protected int dosis;
	protected String fecha_aplicacion;
	protected int estado;
	protected char es_donada;
	/*Grupo1 COVAXIN ASTRAZENECA
	private String numero_lote;
	private String fecha_compra;
	private String fecha_vencimiento; */
	/*Grupo 2 PFIZER  MODERNA
	private int costo_vacuna;
	private int intervalo_siguiente_dosis;
	private int dias_restante_vencimiento; */
	
	
	public Registro() {
		
	}
	public Registro(String documento, int departamento_donde_vive, String sexo, Vacuna vacuna, int dosis,
			String fecha_aplicacion, int estado, char es_donada) {
		this.documento = documento;
		this.departamento_donde_vive = departamento_donde_vive;
		this.sexo = sexo;
		this.vacuna = vacuna;
		this.dosis = dosis;
		this.fecha_aplicacion = fecha_aplicacion;
		this.estado = estado;
		this.es_donada = es_donada;
	}
	
	
	
	public Registro(String documento, int dosis, String fecha_aplicacion, int estado) {
		this.documento = documento;
		this.dosis = dosis;
		this.fecha_aplicacion = fecha_aplicacion;
		this.estado = estado;
	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public int getDepartamento_donde_vive() {
		return departamento_donde_vive;
	}
	public void setDepartamento_donde_vive(int departamento_donde_vive) {
		this.departamento_donde_vive = departamento_donde_vive;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public String getFecha_aplicacion() {
		return fecha_aplicacion;
	}
	public void setFecha_aplicacion(String fecha_aplicacion) {
		this.fecha_aplicacion = fecha_aplicacion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public char getEs_donada() {
		return es_donada;
	}
	public void setEs_donada(char es_donada) {
		this.es_donada = es_donada;
	}
	@Override
	public String toString() {
		return "\nNro. Documento: " + getDocumento() + "\nNombre Dto: "
				+ getDepartamento_donde_vive() + "\nSexo: " + getSexo() + "\nNombre vacuna: " + getVacuna().name()
				+ "\nDosis: " + getDosis() + "\nFecha de aplicación: " + getFecha_aplicacion() + "\nEstado: "
				+ getEstado() + "\n¿Es donada?: " + getEs_donada() + "\n";
	}
	
	
}
