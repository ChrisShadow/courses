package Server;

import java.util.Objects;

public class Suscripcion {
	private int idPersona;
	private String nroCuenta;
	private int codProducto;
	private char estado;
	private int monto;
	private int iva;
       
	
	//constructor
	public Suscripcion() {
	}
	
	public Suscripcion(int idPersona, String nroCuenta, int codProducto, char estado, int monto, int iva) {
		this.idPersona = idPersona;
		this.nroCuenta = nroCuenta;
		this.codProducto = codProducto;
		this.estado = estado;
		this.monto = monto;
		this.iva = iva;
	}
	//Getter & Setter
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codProducto, idPersona, nroCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suscripcion other = (Suscripcion) obj;
		return codProducto == other.getCodProducto() && idPersona == other.getIdPersona()
				&& Objects.equals(nroCuenta, other.getNroCuenta());
	}

	@Override
	public String toString() {
		return "\t\tSuscripcion: \n\n Id Persona: " + getIdPersona() + "\n NroCuenta:" + getNroCuenta()
				+ "\n CodProducto:" + getCodProducto() + "\n Estado: '" + getEstado() + "' \nMonto:"
				+ getMonto() + "\nIva:" + getIva();
	}
	
	public boolean VerificarIVA(int iva) {
		boolean estado=false;
		int montoIVA= (int) Math.floor(this.getMonto() *0.10);
		if (montoIVA == iva)
			estado=true;	
		return estado;
	}
	
}
