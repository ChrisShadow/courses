package Tarea3.Modelo;

import java.util.Objects;

public class Cancion implements Comparable<Cancion>{

	private String tituloC ;
	private String  nombreArt;
	private String  album;
	private String  genero;
	private int anho;
	private int duracion;
	private char estado;
	private char esHit;
	
	
	public Cancion() {
		super();
	}

	
	public Cancion(String tituloC, String nombreArt, String album, String genero, int anho, int duracion, char estado,
			char esHit) {
		this.tituloC = tituloC;
		this.nombreArt = nombreArt;
		this.album = album;
		this.genero = genero;
		this.anho = anho;
		this.duracion = duracion;
		this.estado = estado;
		this.esHit = esHit;
	}
	
	

	public String getTituloC() {
		return tituloC;
	}


	public void setTituloC(String tituloC) {
		this.tituloC = tituloC;
	}


	public String getNombreArt() {
		return nombreArt;
	}


	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public int getAnho() {
		return anho;
	}


	public void setAnho(int anho) {
		this.anho = anho;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public char getEstado() {
		return estado;
	}


	public void setEstado(char estado) {
		this.estado = estado;
	}


	public char getEsHit() {
		return esHit;
	}


	public void setEsHit(char esHit) {
		this.esHit = esHit;
	}

	
	

	@Override
	public String toString() {
		return "getTituloC: \n" + getTituloC() + "\ngetNombreArt: " + getNombreArt() + "\ngetAlbum: "
				+ getAlbum() + "\ngetGenero: " + getGenero() + "\ngetAnho: " + getAnho() + "\ngetDuracion: "
				+ getDuracion() + "\ngetEstado: " + getEstado() + "\ngetEsHit: " + getEsHit() + "\n";
	}

	

	@Override
	public int hashCode() {
		//La clave será el título + el año de la canción
		return Objects.hash(tituloC, anho);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return  Objects.equals(tituloC, other.tituloC)  && anho == other.anho;
	}


	@Override
	public int compareTo(Cancion o) {
		int banNombre=0;
		//-->Punteros de la lista.
		if (this.getNombreArt().charAt(0) > o.getNombreArt().charAt(0)) {
			banNombre=1; //
        } else if (this.getNombreArt().charAt(0) < o.getNombreArt().charAt(0)) {
        	banNombre=-1;
        } else {
        	banNombre=0;
        }
		return banNombre;
	}

}
