package ArreglosTarea;

public class Factura {
	private int periodo;
	private long rucVen;
	private int nroFactura;
	private char tipoDoc;
	private String timbrado;
	private int montoTot;
	private double montoIVA;
	private double montoSiva;
	private int cantItems;
	private long rucComp;
	
	
	//
	public Factura() {
		
	}


	public Factura(int periodo, long rucVen, int nroFactura, char tipoDoc, String timbrado, int montoTot,
			 int cantItems, long rucComp) {
		this.periodo = periodo;
		this.rucVen = rucVen;
		this.nroFactura = nroFactura;
		this.tipoDoc = tipoDoc;
		this.timbrado = timbrado;
		this.montoTot = montoTot;
		this.cantItems = cantItems;
		this.rucComp = rucComp;
	}

	
	//
	public int getPeriodo() {
		return periodo;
	}


	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}


	public long getRucVen() {
		return rucVen;
	}


	public void setRucVen(long rucVen) {
		this.rucVen = rucVen;
	}


	public int getNroFactura() {
		return nroFactura;
	}


	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}


	public char getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(char tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public String getTimbrado() {
		return timbrado;
	}


	public void setTimbrado(String timbrado) {
		this.timbrado = timbrado;
	}


	public int getMontoTot() {
		return montoTot;
	}


	public void setMontoTot(int montoTot) {
		this.montoTot = montoTot;
	}


	public double getMontoIVA() {
		return montoIVA;
	}


	public void setMontoIVA(double montoIVA) {
		this.montoIVA = montoIVA;
	}


	public double getMontoSiva() {
		return montoSiva;
	}


	public void setMontoSiva(double montoSiva) {
		this.montoSiva = montoSiva;
	}


	public int getCantItems() {
		return cantItems;
	}


	public void setCantItems(int cantItems) {
		this.cantItems = cantItems;
	}


	public long getRucComp() {
		return rucComp;
	}


	public void setRucComp(long rucComp) {
		this.rucComp = rucComp;
	}
	
	
	//Calcular monto con IVA
	public void CalcularMontoIVA() {
		double montoIVA=this.getMontoTot()/11;
		this.setMontoIVA(montoIVA);
		//return this.getMontoIVA();
	}
	
	//Calcular Monto sin IVA
	public void CalcularMontoSIVA() {
		double montoSiva= this.getMontoTot() - this.getMontoIVA();
		this.setMontoSiva(montoSiva);
		//return this.getMontoSiva();
	}


	@Override
	public String toString() {
		return getPeriodo() + "\t\t"  + getNroFactura() + "\t\t"
				+ getTimbrado() + "\t\t" + getMontoTot() + "\t\t" + getMontoIVA()
				+ "\t\t" + getMontoSiva();
	}
	
	
	
}


