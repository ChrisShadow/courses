package Modelo;

public class Cuenta {

	private int nroSocio;
	private int nroCuenta;
	private TipoCuenta tipoCuenta;
	private double saldo;
	private Moneda moneda;
	private Estado estado;

	public Cuenta() {
		super();
	}

	public Cuenta(int nroSocio, int nroCuenta, TipoCuenta tipoCuenta, double saldo, Moneda moneda, Estado estado) {
		super();
		this.nroSocio = nroSocio;
		this.nroCuenta = nroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.moneda = moneda;
		this.estado = estado;
	}

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

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cuenta [Nro. Socio= " + getNroSocio() + ", Nro. Cuenta= " + getNroCuenta() + ", Tipo Cuenta= "
				+ getTipoCuenta().toString() + ", Saldo= " + getSaldo() + ", Moneda= " + getMoneda().toString() + ", Estado= "
				+ getEstado().toString() + "]";
	}
	
	

}
