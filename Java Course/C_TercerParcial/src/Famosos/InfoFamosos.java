package Famosos;

public class InfoFamosos {
	protected String nombreApellido;
	protected char sexo;
	protected int fechaNac;
	protected int edad;
	protected String keyFamoso;
	protected int tipoFam;
	
	//
	public InfoFamosos() {
		
	}

	//
	public InfoFamosos(String nombreApellido, char sexo, int fechaNac, String keyFamoso, int tipoFam) {
		this.nombreApellido = nombreApellido;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.keyFamoso = keyFamoso;
		this.tipoFam = tipoFam;
	}

	//
	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getedad() {
		return edad;
	}

	public void setedad(int anhoActual) {
		this.edad = anhoActual-((this.getFechaNac()/10000)-((this.getFechaNac()%10000)/10000));
	}
	
	public int getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(int fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getKeyFamoso() {
		return keyFamoso;
	}

	public void setKeyFamoso(String keyFamoso) {
		this.keyFamoso = keyFamoso;
	}

	public int getTipoFam() {
		return tipoFam;
	}

	public void setTipoFam(int tipoFam) {
		this.tipoFam = tipoFam;
	}

	@Override
	public String toString() {
		String atrib=" ";
		if (this.getSexo()=='M') {
			atrib="Nombre y apellido: " + getNombreApellido() + "\nSexo: Masculino" 
					+ "\nFecha de nacimiento: " + getFechaNac() + "\nId famoso: " + getKeyFamoso() + "\nEdad: " + getedad();
		}else {
			atrib="Nombre y apellido: " + getNombreApellido() + "\nSexo: Femenino" 
					+ "\nFecha de nacimiento: " + getFechaNac() + "\nId famoso: " + getKeyFamoso()  + "\nEdad: " + getedad();
		}
		return atrib;
	}
	
	
}
