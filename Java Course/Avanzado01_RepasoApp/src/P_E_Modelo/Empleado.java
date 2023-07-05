package P_E_Modelo;

public class Empleado extends Persona {
	
	public static final int SUELDO_MINIMO = 1824000;
	private int salario;
	private float horasExtras;
	
	//
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public float getHorasExtras() {
		return horasExtras;
	}
	public void setHorasExtras(float horasExtras) {
		this.horasExtras = horasExtras;
	}
	
	//Sobrecarga punto a
	public Empleado() {
		super();
		this.horasExtras=0;
	}
	
	//Sobrecarga punto b
	public Empleado(String nroCi, String nombre, String apellido, int edad) {
		super(nroCi, nombre, apellido, edad);
		this.salario=SUELDO_MINIMO;
		this.horasExtras=0;
	}
	
	//Sobrecarga punto c
	public Empleado(String nroCi, String nombre, String apellido, int edad, char sexo, String estadoCivil, int salario) {
		super(nroCi, nombre, apellido, edad, sexo, estadoCivil);
		this.salario=salario;
	}
	
	//
	@Override
	public String toString() {
		return super.toString().concat("\nSalario: "+ this.getSalario()+"\nHoras extras: "+ this.getHorasExtras() + "\n");
	}
	
	//Cálculo
	public int CalcularSalario() {
		
		return (int)(0.77 * (this.salario + this.salario / 192 * this.horasExtras));
	}
	
	
	
	
	
	
	
	
	
	
	//
	
}
