package Modelo;

public class Entidad {

	private int nroSocio;
	private int nroCuenta;
	private String tipoCuenta;
	private double saldo;
	private String moneda;
	private String estado;
	
	public int getNroSocio() {
		return nroSocio;
	}


	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}


	public int getNroCuenta() {
		return nroCuenta;
	}


	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getMoneda() {
		return moneda;
	}


	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
