package UAA.model;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
	
	private String nroDoc; //Key
	private String tipoDoc;   //Key 
	private String nombreApellido; 
	private String tele; //Teléfono
	private char sex;
	private String mail;
	private char hasB;

	public Alumno() {
		super();
	}

	public Alumno(String nroDoc, String tipoDoc, String nombreApellido, String tele, char sex, String mail, char hasB) {
		this.nroDoc = nroDoc;
		this.tipoDoc = tipoDoc;
		this.nombreApellido = nombreApellido;
		this.tele = tele;
		this.sex = sex;
		this.mail = mail;
		this.hasB = hasB;
	}

	

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex.charAt(0);
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public char getHasB() {
		return hasB;
	}

	public void setHasB(String hasB) {
		this.hasB = hasB.charAt(0);
	}

	
	
	
	@Override
	public String toString() {
		return "\nDATOS DEL ESTUDIANTE\n\nNro de Documento: " + getNroDoc() + "\nTipo de Documento: " + getTipoDoc() + "\nNombre y Apellido: "
				+ getNombreApellido() + "\nTeléfono: " + getTele() + "\nSexo: " + getSex() + "\nDirección de correo electrónico: "
				+ getMail() + "\n¿Posee beca?: " + getHasB() + "\n";
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(nroDoc, tipoDoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return hasB == other.hasB && Objects.equals(mail, other.mail)
				&& Objects.equals(nombreApellido, other.nombreApellido) && Objects.equals(nroDoc, other.nroDoc)
				&& sex == other.sex && Objects.equals(tele, other.tele) && Objects.equals(tipoDoc, other.tipoDoc);
	}

	@Override
	public int compareTo(Alumno o) {
		int banNombre=0;
		//-->Punteros de la lista.
		if (this.getNombreApellido().charAt(0) > o.getNombreApellido().charAt(0)) {
			banNombre=1; //
        } else if (this.getNombreApellido().charAt(0) < o.getNombreApellido().charAt(0)) {
        	banNombre=-1;
        } else {
        	banNombre=0;
        }
		return banNombre;
	}

	
}
