package Bicicleta;

public class Adulto extends Paseo {
	private double altura;

	public Adulto() {
		super();
	}

	public Adulto(String marca, String modelo, String serie, int nroAro, double montoAlq, String tipo,
			double grososrRueda, String tipoPaseo,double altura) {
		super(marca, modelo, serie, nroAro, montoAlq, tipo, grososrRueda, tipoPaseo);
		this.altura=altura;
	}

	//
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

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
