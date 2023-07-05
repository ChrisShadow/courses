package Bicicleta;

public class Ninhos extends Paseo {
	private String tipoAsiento;

	public Ninhos() {
		super();
	}

	public Ninhos(String marca, String modelo, String serie, int nroAro, double montoAlq, String tipo,
			double grososrRueda, String tipoPaseo,String tipoAsiento) {
		super(marca, modelo, serie, nroAro, montoAlq, tipo, grososrRueda, tipoPaseo);
		this.tipoAsiento=tipoAsiento;
	}

	//
	public String getTipoAsiento() {
		return tipoAsiento;
	}

	public void setTipoAsiento(String tipoAsiento) {
		this.tipoAsiento = tipoAsiento;
	}

	//
	@Override
	public void Girar() {
		super.Girar();
	}

	@Override
	public void DisminuirVelocidad() {
		super.DisminuirVelocidad();
	}

	@Override
	public void AumentarVelocidad(int cantidad) {
		super.AumentarVelocidad(cantidad);
	}
	
	
	
	
}
