package ExamenFinal;

public class Grupo1 extends Registro{
	//Grupo1 COVAXIN ASTRAZENECA
	private String numero_lote;
	private String fecha_compra;
	private String fecha_vencimiento;
	
	public Grupo1() {
		super();
	}
	public Grupo1(String documento, int departamento_donde_vive, String sexo, Vacuna vacuna, int dosis,
			String fecha_aplicacion, int estado, char es_donada, String numero_lote , String fecha_compra, String fecha_vencimiento ) {
		super(documento, departamento_donde_vive, sexo, vacuna, dosis, fecha_aplicacion, estado, es_donada);
		this.numero_lote= numero_lote;
		this.fecha_compra=fecha_compra;
		this.fecha_vencimiento=fecha_vencimiento;
		
	}
	public String getNumero_lote() {
		return numero_lote;
	}
	public void setNumero_lote(String numero_lote) {
		this.numero_lote = numero_lote;
	}
	public String getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
	@Override
	public String toString() {
		return  "\nDatos generales: " + super.toString() +"\nNro. Lote: " + getNumero_lote() + "\nFecha compra: " + getFecha_compra()
				+ "\nFecha Vto.: " + getFecha_vencimiento() + "\n";
	} 
	
	
	
	
}
