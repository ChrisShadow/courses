package Server;

import java.util.Objects;

public class Professors {
	String nombreCompleto;
	String cedula;
	char semestre;
	String materia;
	String curso;
	String facultad;
	int anholectivo;
	
	public Professors() {
		
	}

	public Professors(String nombreCompleto, String cedula, char semestre, String materia, String curso, String facultad, int anholectivo) {
		this.nombreCompleto = nombreCompleto;
		this.cedula = cedula;
		this.semestre = semestre;
		this.materia = materia;
		this.curso = curso;
		this.facultad = facultad;
		this.anholectivo = anholectivo;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public char getSemestre() {
		return semestre;
	}

	public void setSemestre(char semestre) {
		this.semestre = semestre;
	}
	
	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public int getAnholectivo() {
		return anholectivo;
	}

	public void setAnholectivo(int anholectivo) {
		this.anholectivo = anholectivo;
	}

	@Override
	public String toString() {
		return "\nNombre completo del tutor: " + getNombreCompleto() + "\nNro. Ci: " + getCedula()
				+ "\nSemestre: " + getSemestre() +"\nMateria: " + getMateria()+"\nCurso: " + getCurso() +"\nFacultad: " + getFacultad() + "\nAño lectivo: "
				+ getAnholectivo() + "\n";
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 17 * hash + Objects.hashCode(this.cedula);
		hash = 17 * hash + this.semestre;
		hash = 17 * hash + Objects.hashCode(this.materia);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Professors objParametro = (Professors) obj;
		if (!Objects.equals(this.cedula, objParametro.cedula)) {
			return false;
		}
		if (!Objects.equals(this.materia, objParametro.materia)) {
			return false;
		}
		if (!Objects.equals(this.curso, objParametro.curso)) {
			return false;
		}
		if (this.semestre != objParametro.semestre) {
			return false;
		}
		if (this.anholectivo != objParametro.anholectivo) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	
}
