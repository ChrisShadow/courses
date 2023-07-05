package Cliente;

public class Nativo extends Cliente{
	private String ciudadOrig;
	private String direccion;
	
	//
	public Nativo() {
		super();
	}
	
	public Nativo(String nombre, String apellido, TipoDocumento tipoDoc, String nroDoc, String email,String ciudadOrig,String direccion) {
		super(nombre, apellido, tipoDoc, nroDoc, email);
		this.ciudadOrig=ciudadOrig;
		this.direccion=direccion;
	}

	//
	public String getCiudadOrig() {
		return ciudadOrig;
	}

	public void setCiudadOrig(String ciudadOrig) {
		this.ciudadOrig = ciudadOrig;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	@Override  //Sobrescritura de la super clase
	public String toString() {
		return  super.toString() + "\nCiudad de origen: " + getCiudadOrig() + "\nDirección de residencia: " + getDireccion();
	}
	
	
	
	
	
	
	
}
