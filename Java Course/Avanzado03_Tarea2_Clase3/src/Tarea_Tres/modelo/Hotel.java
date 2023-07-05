package Tarea_Tres.modelo;

import java.util.Objects;

public class Hotel implements Comparable<Hotel> {
	 private int codHotel;
	 private String nombre;
	 private String zona;
	 private double precio;
	  
	public Hotel() {
	  super();	
	}

	public Hotel(int codHotel, String nombre, String zona, double precio) {
		this.codHotel = codHotel;
		this.nombre = nombre;
		this.zona = zona;
		this.precio = precio;
	}

	public int getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(int codHotel) {
		this.codHotel = codHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "CodHotel: " + getCodHotel() + "\nNombre: " + getNombre() + "\nZona:" + getZona()
				+ "\nPrecio: " + getPrecio() + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codHotel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return codHotel == other.codHotel && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(zona, other.zona);
	}

	@Override
	public int compareTo(Hotel o) {
		int banN=0;
		//this hPosterior y o hAnterior-->Punteros de la lista.
		if (this.getPrecio() > o.getPrecio()) {
            banN=1; //
        } else if (this.getPrecio() < o.getPrecio()) {
        	 banN=-1;
        } else {
        	 banN=0;
        }
		return banN;
	}
	
	
	
	 
}
