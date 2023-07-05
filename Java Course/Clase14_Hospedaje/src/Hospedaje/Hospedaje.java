package Hospedaje;

public class Hospedaje {
	private int nroHos;
	private String nroDoc;
	private int canDiasHos;
	private int nroPiso;
	private int nroHabi;
	private Pais pais;
	private int montoTotal;
	private int montoCan;
	private Estado est;
	
	
	public Hospedaje() {
		
	}

	
	
	public Hospedaje(int nroHos) {
		this.nroHos = nroHos;
	}



	public Hospedaje(int nroHos, String nroDoc, int canDiasHos, int nroPiso, int nroHabi, Pais pais, int montoTotal,
			int montoCan, Estado est) {
		this.nroHos = nroHos;
		this.nroDoc = nroDoc;
		this.canDiasHos = canDiasHos;
		this.nroPiso = nroPiso;
		this.nroHabi = nroHabi;
		this.pais = pais;
		this.montoTotal = montoTotal;
		this.montoCan = montoCan;
		this.est = est;
	}

	public Hospedaje(String nroDoc, int canDiasHos, int nroPiso, int nroHabi, Pais pais, int montoTotal, int montoCan,
			Estado est) {
		this.nroDoc = nroDoc;
		this.canDiasHos = canDiasHos;
		this.nroPiso = nroPiso;
		this.nroHabi = nroHabi;
		this.pais = pais;
		this.montoTotal = montoTotal;
		this.montoCan = montoCan;
		this.est = est;
	}



	public int getNroHos() {
		return nroHos;
	}



	public void setNroHos(int nroHos) {
		this.nroHos = nroHos;
	}



	public String getNroDoc() {
		return nroDoc;
	}



	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}



	public int getCanDiasHos() {
		return canDiasHos;
	}



	public void setCanDiasHos(int canDiasHos) {
		this.canDiasHos = canDiasHos;
	}



	public int getNroPiso() {
		return nroPiso;
	}



	public void setNroPiso(int nroPiso) {
		this.nroPiso = nroPiso;
	}



	public int getNroHabi() {
		return nroHabi;
	}



	public void setNroHabi(int nroHabi) {
		this.nroHabi = nroHabi;
	}



	public Pais getPais() {
		return pais;
	}



	public void setPais(Pais pais) {
		this.pais = pais;
	}



	public int getMontoTotal() {
		return montoTotal;
	}



	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}



	public int getMontoCan() {
		return montoCan;
	}



	public void setMontoCan(int montoCan) {
		this.montoCan = montoCan;
	}



	public Estado getEst() {
		return est;
	}



	public void setEst(Estado est) {
		this.est = est;
	}



	@Override
	public String toString() {
		return "\nIdentificador del hospedaje: " + getNroHos() + "\nNro de documento: " + getNroDoc() + "\nCantidad de días: "
				+ getCanDiasHos() + "\nNro piso: " + getNroPiso() + "\nNro habitación: " + getNroHabi() + "\nPaís: "
				+ getPais() + "\nMonto total: " + getMontoTotal() + "\nMonto cancelado: " + getMontoCan()
				+ "\nEstado: " + getEst();
	}
	
	public String Linea() {
		return "Identificador del hospedaje: " + getNroHos() + " * Nro de documento: " + getNroDoc() + " * Cantidad de días: "
				+ getCanDiasHos() + " * Nro piso: " + getNroPiso() + " * Nro habitación: " + getNroHabi() + " * País: "
				+ getPais() + " * Monto total: " + getMontoTotal() + " * Monto cancelado: " + getMontoCan()
				+ " * Estado: " + getEst();
		
	}
	
	
}
