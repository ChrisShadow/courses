package Cliente;

public class Cliente {
	protected String nombre;
	protected String apellido;
	protected TipoDocumento tipoDoc;
	protected String nroDoc;
	protected String email;
	
	//
	public Cliente() {
		
	}

	public Cliente(String nombre, String apellido, TipoDocumento tipoDoc, String nroDoc, String email) {
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

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
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
		//Evaluar el tipo de documento para mostrar dependiendo del objeto
		TipoDocumento CI= TipoDocumento.CI;
		if (tipoDoc.equals(CI)) {
			return "---Datos del cliente Nativo ---\nNombre: " + getNombre() + " " + getApellido() + " \nTipo de documento: "
					+ getTipoDoc() + "\nDocumento: " + getNroDoc() + "\nCorreo: " + getEmail();
		}else {
			return "---Datos del cliente Extranjero ---\nNombre: " + getNombre() + " " + getApellido() + " \nTipo de documento: "
					+ getTipoDoc() + "\nDocumento: " + getNroDoc() + "\nCorreo: " + getEmail();
		}
		
	}
	
	
	
	
	
	
}



