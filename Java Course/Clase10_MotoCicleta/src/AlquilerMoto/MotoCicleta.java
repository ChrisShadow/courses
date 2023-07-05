package AlquilerMoto;

public class MotoCicleta {
	private String marca;
	private int anho;
	private String chasis;
	private int cantCilin;
	private double montoAlq;
	private String tipoMoto;
	private String descrp;
	
	//
	public MotoCicleta() {
		super();
	}

	//
	public MotoCicleta(String marca, int anho, String chasis, int cantCilin, double montoAlq, String tipoMoto,
			String descrp) {
		this.marca = marca;
		this.anho = anho;
		this.chasis = chasis;
		this.cantCilin = cantCilin;
		this.montoAlq = montoAlq;
		this.tipoMoto = tipoMoto;
		this.descrp = descrp;
	}

	//
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public int getCantCilin() {
		return cantCilin;
	}

	public void setCantCilin(int cantCilin) {
		this.cantCilin = cantCilin;
	}

	public double getMontoAlq() {
		return montoAlq;
	}

	public void setMontoAlq(double montoAlq) {
		this.montoAlq = montoAlq;
	}

	public String getTipoMoto() {
		return tipoMoto;
	}

	public void setTipoMoto(String tipoMoto) {
		this.tipoMoto = tipoMoto;
	}

	public String getDescrp() {
		return descrp;
	}

	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}

	@Override
	public String toString() {
		return "\t\t"+ getChasis() + "\t\t" + getTipoMoto()  + "\t\t" + getMarca()  + 
				 "\t\t" + getAnho() + "\t\t" + getMontoAlq()  + "\t\t" + getDescrp();
	}
	

	
}
