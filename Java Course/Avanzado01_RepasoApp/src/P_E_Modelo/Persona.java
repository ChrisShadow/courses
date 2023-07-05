package P_E_Modelo;

public class Persona {
	
	protected String nroCi;
	protected String nombre;
	protected String apellido;
	protected int edad;
	protected char sexo;
	protected String estadoCivil;
	
	//
	public String getNroCi() {
		return nroCi;
	}
	public void setNroCi(String nroCi) {
		this.nroCi = nroCi;
	}
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	/*Constructores
	 * sin parámetros
	*/
	public Persona() {
		this.nroCi="6695011";
		this.nombre="Chris";
		this.apellido="Rolón";
		this.edad=22;
		this.sexo='M';
		this.estadoCivil="divorciado";
		
	}
	//Por defecto
	public Persona(String nroCi, String nombre, String apellido, int edad) {
		this.nroCi = nroCi;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sexo='M';
		this.estadoCivil="soltero";
	}
	//De inicialización
	public Persona(String nroCi, String nombre, String apellido, int edad, char sexo, String estadoCivil) {
		this.nroCi = nroCi;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
	}
	@Override
	public String toString() {
		return "\nNro Ci: " + getNroCi() + "\nNombre: " + getNombre() + "\nApellido: " + getApellido()
				+ "\nEdad: " + getEdad() + "\nSexo: " + getSexo() + "\nEstado: " + getEstadoCivil()+"\n";
	}
	
	//
	
	
	
	
	
	
	
}
