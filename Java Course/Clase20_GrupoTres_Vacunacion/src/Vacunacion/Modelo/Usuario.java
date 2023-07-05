package Vacunacion.Modelo;

public class Usuario {
	private int id;
	private String nombre;
	private String distrito;
	private int nroReg;
	private String correo;
	private String estado;
	
	//
	public Usuario() {
		
	}

	//Con Pk
	public Usuario(int id) {
		this.id = id;
	}

	//Con valores de inserción sin id
	public Usuario(String nombre, String distrito, int nroReg, String correo, String estado) {
		this.nombre = nombre;
		this.distrito = distrito;
		this.nroReg = nroReg;
		this.correo = correo;
		this.estado = estado;
	}

	//Con valores de operación con PK
	public Usuario(int id, String nombre, String distrito, int nroReg, String correo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.distrito = distrito;
		this.nroReg = nroReg;
		this.correo = correo;
		this.estado = estado;
	}

	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getNroReg() {
		return nroReg;
	}

	public void setNroReg(int nroReg) {
		this.nroReg = nroReg;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "\nIdentificador del usuario: " + getId() + "\nNombre: " + getNombre() + "\nDistrito: " + getDistrito()
				+ "\nNro. Registro: " + getNroReg() + "\nCorreo: " + getCorreo() + "\nEstado: " + getEstado()+ "\n " ;
	}
	
	
	
	
	
}
