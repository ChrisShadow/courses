package clase6ChrisRolon;

public class Empleado {
	//Atributos 
	private String nombre;
	private String apellido;
	private char tipoempleado;
	private int antiguedad;
	private double salario;
	
	//Constructores
	public Empleado() {
		
	}

	public Empleado(String nombre, String apellido, char tipoempleado, int antiguedad, double salario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoempleado = tipoempleado;
		this.antiguedad = antiguedad;
		this.salario = salario;
	}

	//Métodos accesores 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public char getTipoempleado() {
		return tipoempleado;
	}

	public void setTipoempleado(char tipoempleado) {
		this.tipoempleado = tipoempleado;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	//Métodos
	public double AumentarSalario(double porcentaje){
		return this.getSalario()+((this.getSalario()*porcentaje)/100);
	}
	
}
