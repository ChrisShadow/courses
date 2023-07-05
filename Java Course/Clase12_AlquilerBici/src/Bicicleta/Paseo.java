package Bicicleta;

public abstract class Paseo extends Bicicleta {
	protected double grososrRueda;
	protected String tipoPaseo;
	
	
	//
	public Paseo() {
		super();
	}

	//
	public Paseo(String marca, String modelo, String serie, int nroAro, double montoAlq, String tipo,double grososrRueda,String tipoPaseo) {
		super(marca, modelo, serie, nroAro, montoAlq, tipo);
		this.grososrRueda=grososrRueda;
		this.tipoPaseo=tipoPaseo;
	}

	//
	public double getGrososrRueda() {
		return grososrRueda;
	}

	public void setGrososrRueda(double grososrRueda) {
		this.grososrRueda = grososrRueda;
	}
	
	public String getTipoPaseo() {
		return tipoPaseo;
	}

	public void setTipoPaseo(String tipoPaseo) {
		this.tipoPaseo = tipoPaseo;
	}

	@Override
	public void Girar() {
		System.err.println("Se ha realizado un giro que estuvo al borde de generar su muerte. ¡Más cuidado, pendejo!");
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
