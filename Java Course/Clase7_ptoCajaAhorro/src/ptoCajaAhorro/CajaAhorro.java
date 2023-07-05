package ptoCajaAhorro;

import java.util.Objects;

public class CajaAhorro {
	private int anhoApertura;
	private int mesApertura;
	private double montoTotal;
	private double tasa;
	private int plazo;
	private int catAhorro;
	private char catCliente;
	private char mercado;
	private double ingNeto;
	private double montInteres;

	//
	public CajaAhorro() {

	}

	public CajaAhorro(int anhoApertura, int mesApertura, double montoTotal, double tasa, int plazo, int catAhorro,
			char mercado, char catCliente) {
		this.anhoApertura = anhoApertura;
		this.mesApertura = mesApertura;
		this.montoTotal = montoTotal;
		this.tasa = tasa;
		this.plazo = plazo;
		this.catAhorro = catAhorro;
		this.mercado = mercado;
		this.catCliente = catCliente;
	}

	//
	public int getAnhoApertura() {
		return anhoApertura;
	}

	public void setAnhoApertura(int anhoApertura) {
		this.anhoApertura = anhoApertura;
	}

	public int getMesApertura() {
		return mesApertura;
	}

	public void setMesApertura(int mesApertura) {
		this.mesApertura = mesApertura;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public int getCatAhorro() {
		return catAhorro;
	}

	public void setCatAhorro(int catAhorro) {
		this.catAhorro = catAhorro;
	}

	public char getMercado() {
		return mercado;
	}

	public void setMercado(char mercado) {
		this.mercado = mercado;
	}

	public char getCatCliente() {
		return catCliente;
	}

	public void setCatCliente(char catCliente) {
		this.catCliente = catCliente;
	}

	// Método para calcular Ingreso Neto
	public double ObtnerIngresoNeto(int salarioMin) {
		// Controlar año

		if (this.getAnhoApertura() <= 2015) {
			// Primer cuadro
			if (this.getMercado() == 'A') {
				if (this.getCatAhorro() == 101 && this.getCatCliente() == 'A') {
					this.ingNeto= (salarioMin*3)*1.05-(10110*(this.getTasa()/1200));
				} else if (this.getCatAhorro() == 102 && this.getCatCliente() == 'I') {
					this.ingNeto= (salarioMin*2)*0.75-(15250*(this.getTasa()/1200));
				}
			} else if (this.getMercado() == 'B') {
				if (this.getCatAhorro() == 101 && this.getCatCliente() == 'A') {
					this.ingNeto= (salarioMin*3)*0.93-(21000*(this.getTasa()/1200));
				} else if (this.getCatAhorro() == 102 && this.getCatCliente() == 'I') {
					this.ingNeto= (salarioMin*2)*0.57-(25900*(this.getTasa()/1200));
				}
			} else {
				if(this.getCatAhorro()==101 && this.getCatCliente()=='A') {
					this.ingNeto= (salarioMin*3)*0.84-(30250*(this.getTasa()/1200));
				}else if(this.getCatAhorro()==102 && this.getCatCliente()=='I') {
					this.ingNeto= (salarioMin*2)*0.49-(35780*(this.getTasa()/1200));
				}
			}

		} else {
			// Segundo cuadro
			if (this.getMercado() == 'A') {
				if (this.getCatAhorro() == 101 && this.getCatCliente() == 'A') {
					this.ingNeto= (salarioMin*4)*0.75-(10110*(this.getTasa()/1100));
				} else if (this.getCatAhorro() == 102 && this.getCatCliente() == 'I') {
					this.ingNeto= (salarioMin*3)*0.63-(15050*(this.getTasa()/1100));
				}
			} else if (this.getMercado() == 'B') {
				if (this.getCatAhorro() == 101 && this.getCatCliente() == 'A') {
					this.ingNeto= (salarioMin*4)*0.39-(20000*(this.getTasa()/1100));
				} else if (this.getCatAhorro() == 102 && this.getCatCliente() == 'I') {
					this.ingNeto= (salarioMin*3)*0.72-(24000*(this.getTasa()/1100));
				}
			} else {
				if(this.getCatAhorro()==101 && this.getCatCliente()=='A') {
					this.ingNeto= (salarioMin*4)*0.48-(32000*(this.getTasa()/1100));
				}else if(this.getCatAhorro()==102 && this.getCatCliente()=='I') {
					this.ingNeto= (salarioMin*3)*0.37-(41000*(this.getTasa()/1100));
				}
			}
		}
		return this.ingNeto;
	}

	// Método para calcular el Monto de interés
	public double ObtenerMontoInteres(int salarioMin) {
		this.montInteres = ((this.getMontoTotal() / 12) - salarioMin) * this.getTasa()
				* (this.getPlazo() - (12 - this.getMesApertura()));
		return this.montInteres;
	}

	// Método para mostrar
	@Override
	public String toString() {
		return "CajaAhorro [ingNeto=" + ingNeto + ", montInteres=" + montInteres + ", getAnhoApertura()="
				+ getAnhoApertura() + ", getMesApertura()=" + getMesApertura() + ", getMontoTotal()=" + getMontoTotal()
				+ ", getTasa()=" + getTasa() + ", getPlazo()=" + getPlazo() + ", getCatAhorro()=" + getCatAhorro()
				+ ", getMercado()=" + getMercado() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(anhoApertura, catAhorro, catCliente, ingNeto, mercado, mesApertura, montInteres, montoTotal,
				plazo, tasa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CajaAhorro other = (CajaAhorro) obj;
		return anhoApertura == other.anhoApertura && catAhorro == other.catAhorro && catCliente == other.catCliente
				&& Double.doubleToLongBits(ingNeto) == Double.doubleToLongBits(other.ingNeto)
				&& mercado == other.mercado && mesApertura == other.mesApertura
				&& Double.doubleToLongBits(montInteres) == Double.doubleToLongBits(other.montInteres)
				&& Double.doubleToLongBits(montoTotal) == Double.doubleToLongBits(other.montoTotal)
				&& plazo == other.plazo && Double.doubleToLongBits(tasa) == Double.doubleToLongBits(other.tasa);
	}
	
	
}
