package UAA.model;

import java.util.HashSet;
import java.util.Objects;

public class Curso implements Comparable<Curso> {

	private int codFac; //Key
	private int nroCurso; //Key
	private String materia;
	private String modalidad;
	private int codProf;
	private char dia;
	private char turno;
	private int nroPiso;
	private int nroAula;
	private char estado; 
	public HashSet<Alumno> listA ;
	
	
	public Curso() {
		super();
		this.listA=new HashSet<Alumno>();
	}


	public Curso(int codFac, int nroCurso, String materia, String modalidad, int codProf,  int nroPiso, int nroAula) {
		this.codFac= codFac; 
		this.nroCurso= nroCurso;
		this.materia = materia;
		this.modalidad = modalidad;
		this.codProf = codProf;
		this.nroPiso = nroPiso;
		this.nroAula = nroAula;
		this.listA=new HashSet<Alumno>();
	}
	
	
	
	public int getCodFac() {
		return codFac;
	}


	public void setCodFac(int codFac) {
		this.codFac = codFac;
	}


	public int getNroCurso() {
		return nroCurso;
	}


	public void setNroCurso(int nroCurso) {
		this.nroCurso = nroCurso;
	}


	public String getMateria() {
		return materia;
	}


	public void setMateria(String materia) {
		this.materia = materia;
	}


	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}


	public int getCodProf() {
		return codProf;
	}


	public void setCodProf(int codProf) {
		this.codProf = codProf;
	}


	public char getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia.charAt(0);
	}


	public char getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno.charAt(0);
	}


	public int getNroPiso() {
		return nroPiso;
	}


	public void setNroPiso(int nroPiso) {
		this.nroPiso = nroPiso;
	}


	public int getNroAula() {
		return nroAula;
	}


	public void setNroAula(int nroAula) {
		this.nroAula = nroAula;
	}


	public char getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado.charAt(0);
	}


	public HashSet<Alumno> getListA() {
		return listA;
	}


	public void setListA(Alumno A) {
		this.listA.add(A);
	}

	

	@Override
	public String toString() {
		String linea = "\nDATOS DEL CURSO\n\nCódigo de la facultad:" + getCodFac() + "\nNúmero del curso: "+ getNroCurso() + "\nMateria: " + getMateria() + "\nModalidad: " + getModalidad() + "\nCódigo del profesor: "
				+ getCodProf() + "\nDía: " + getDia() + "\nTurno: " + getTurno() + "\nNúmero de Piso: "
				+ getNroPiso() + "\nNúmero de Aula: " + getNroAula() + "\nEstado: " + getEstado() + "\nListado de alumnos: " ;
				for (Alumno alu: getListA()) {
					linea+=alu.toString().concat("\n");
				}	
		return linea;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codFac,nroCurso);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return codFac == other.codFac && codProf == other.codProf && dia == other.dia && estado == other.estado
				&& Objects.equals(listA, other.listA) && Objects.equals(materia, other.materia)
				&& Objects.equals(modalidad, other.modalidad) && nroAula == other.nroAula && nroCurso == other.nroCurso
				&& nroPiso == other.nroPiso && turno == other.turno;
	}


	@Override
	public int compareTo(Curso o) {
		int banNombre=0;
		//-->Punteros de la lista.
		if (this.getNroPiso() > o.getNroPiso() && this.getNroAula() > o.getNroAula()) { //ASC
			banNombre=1; //
        } else if (this.getNroPiso() < o.getNroPiso() && this.getNroAula() < o.getNroAula()) { //DSC
        	banNombre=-1;
        } else {
        	if(this.getNroPiso() == o.getNroPiso() && this.getNroAula() == o.getNroAula())
        		banNombre=0;
        }
		return banNombre;
	}

}
