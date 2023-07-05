package AlquilerBici;

import Bicicleta.Bicicleta;

public class Alquiler {
	private String fechaAlq;
	private String fechaDev;
	private double importe;
	private double IVA;
	private Bicicleta alqui[];
	
	//
	public Alquiler() {
		this.importe =0;
		this.IVA = 0;
		this.alqui=new Bicicleta[15];
	}

	public Alquiler(String fechaAlq, String fechaDev) {
		this.fechaAlq = fechaAlq;
		this.fechaDev = fechaDev;
		this.importe =0;
		this.IVA = 0;
		this.alqui=new Bicicleta[15];
	}

	//
	public String getFechaAlq() {
		return fechaAlq;
	}

	public void setFechaAlq(String fechaAlq) {
		this.fechaAlq = fechaAlq;
	}

	public String getFechaDev() {
		return fechaDev;
	}

	public void setFechaDev(String fechaDev) {
		this.fechaDev = fechaDev;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getIVA() {
		return IVA;
	}

	public void setIVA(double iVA) {
		IVA = iVA;
	}

	public Bicicleta[] getAlqui() {
		return alqui;
	}

	public void setAlqui(Bicicleta[] alqui) {
		this.alqui = alqui;
	}

	//Calcular importe del alquiler
	public void CalcularImporteAlquiler() {
		double acuImporte=0;
		for (int i = 0; i <= alqui.length; i++) {
			acuImporte+=alqui[i].getMontoAlq();
		}
		this.setImporte(acuImporte);
		this.setIVA(acuImporte*0.1);
	}
	
	
	@Override
	public String toString() {
		double acuImporte=0;
		String det="\n--------FACTURACIÓN DE ALQUILER--------" + "\nFecha alquiler: " + getFechaAlq() + "\nFecha devolución: " + getFechaDev();
		for (int i = 0; i <= alqui.length; i++) {
			acuImporte+=alqui[i].getMontoAlq();
		}
		this.setImporte(acuImporte);
		this.setIVA(acuImporte*0.1);
		det.concat("\n Importe total: " +  getImporte() + "\nMonto IVA: " + getIVA());
		return det;
	}
	
	
	
	
	
}
