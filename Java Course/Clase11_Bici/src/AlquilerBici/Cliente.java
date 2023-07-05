package AlquilerBici;

public class Cliente {
	private String nombre;
	private String apellido;
	private String tipoDoc;
	private int nroDoc;
	private String email;
	
	
	//
	public Cliente() {
		
	}


	public Cliente(String nombre, String apellido, String tipoDoc, int nroDoc, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
		this.email = email;
	}

	//
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


	public String getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public int getNroDoc() {
		return nroDoc;
	}


	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "---Datos del cliente ---\nNombre: " + getNombre() + " " + getApellido() + " \nTipo de documento: "
				+ getTipoDoc() + "\nDocumento: " + getNroDoc() + "\nCorreo: " + getEmail();
	}
	
	
	
}
