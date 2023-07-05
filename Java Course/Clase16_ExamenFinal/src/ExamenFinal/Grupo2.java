package ExamenFinal;

public class Grupo2 extends Registro{
	//Grupo 2 PFIZER  MODERNA
	private int costo_vacuna;
	private int intervalo_siguiente_dosis;
	private int dias_restante_vencimiento;
	
	public Grupo2() {
		super();
	}
	public Grupo2(String documento, int departamento_donde_vive, String sexo, Vacuna vacuna, int dosis,
			String fecha_aplicacion, int estado, char es_donada, int costo_vacuna,int intervalo_siguiente_dosis, int dias_restante_vencimiento ) {
		super(documento, departamento_donde_vive, sexo, vacuna, dosis, fecha_aplicacion, estado, es_donada);
		this.costo_vacuna=costo_vacuna;
		this.intervalo_siguiente_dosis=intervalo_siguiente_dosis;
		this.dias_restante_vencimiento=dias_restante_vencimiento;
	}
	public int getCosto_vacuna() {
		return costo_vacuna;
	}
	public void setCosto_vacuna(int costo_vacuna) {
		this.costo_vacuna = costo_vacuna;
	}
	public int getIntervalo_siguiente_dosis() {
		return intervalo_siguiente_dosis;
	}
	public void setIntervalo_siguiente_dosis(int intervalo_siguiente_dosis) {
		this.intervalo_siguiente_dosis = intervalo_siguiente_dosis;
	}
	public int getDias_restante_vencimiento() {
		return dias_restante_vencimiento;
	}
	public void setDias_restante_vencimiento(int dias_restante_vencimiento) {
		this.dias_restante_vencimiento = dias_restante_vencimiento;
	}
	@Override
	public String toString() {
		return  "\nDatos generales: " + super.toString() + "\nCosto Vacuna: " + getCosto_vacuna() + "\nIntévalo: "
				+ getIntervalo_siguiente_dosis() + "\nDías restantes: " + getDias_restante_vencimiento()+"\n";
	} 
	
	
	
}
