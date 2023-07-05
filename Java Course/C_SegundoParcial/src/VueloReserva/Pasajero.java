package VueloReserva;


public class Pasajero {
	private int nrodoc ;
	private char tipodoc;
	private int categoria;
	private int edad;
	private String gmail;
	
	//
	public Pasajero() {
		
	}

	public Pasajero(int nrodoc, char tipodoc, int categoria, int edad, String gmail) {
		this.nrodoc = nrodoc;
		this.tipodoc = tipodoc;
		this.categoria = categoria;
		this.edad = edad;
		this.gmail = gmail;
	}
	
	//
	public int getNrodoc() {
		return nrodoc;
	}

	public void setNrodoc(int nrodoc) {
		this.nrodoc = nrodoc;
	}

	public char getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(char tipodoc) {
		this.tipodoc = tipodoc;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	//Método para mostrar
	@Override
	public String toString() {
		return "Pasajero [getNrodoc()=" + getNrodoc() + ", getTipodoc()=" + getTipodoc() + ", getCategoria()="
				+ getCategoria() + ", getEdad()=" + getEdad() + ", getGmail()=" + getGmail() + "]";
	}
	
	
	
	
	
}
