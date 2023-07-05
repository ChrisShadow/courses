package Cliente;

public class Extranjero extends Cliente{
	private String paisOrig;
	private String telefCont;
	
	//
	public Extranjero() {
		super();
	}
	public Extranjero(String nombre, String apellido, TipoDocumento tipoDoc, String nroDoc, String email,String paisOrig,String telefCont) {
		super(nombre, apellido, tipoDoc, nroDoc, email);
		this.paisOrig=paisOrig;
		this.telefCont=telefCont;
	}
	
	//
	public String getPaisOrig() {
		return paisOrig;
	}
	public void setPaisOrig(String paisOrig) {
		this.paisOrig = paisOrig;
	}
	public String getTelefCont() {
		return telefCont;
	}
	public void setTelefCont(String telefCont) {
		this.telefCont = telefCont;
	}
	
	
	//
	@Override //Sobrescritura de la super clase
	public String toString() {
		return   super.toString() + "\nPaís de origen: " + getPaisOrig() + "\nTeléfono de contacto" + getTelefCont();
	}
	
	
}
