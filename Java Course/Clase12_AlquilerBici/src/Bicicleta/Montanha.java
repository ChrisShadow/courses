package Bicicleta;

public class Montanha extends Bicicleta {

	private String materialPed;
	private String tipoSusp;
	private double peso;
	
	
	public Montanha() {
		super();
	}

	public Montanha(String marca, String modelo, String serie, int nroAro, double montoAlq, String tipo,String materialPed,String tipoSusp,double peso) {
		super(marca, modelo, serie, nroAro, montoAlq, tipo);
		this.materialPed=materialPed;
		this.tipoSusp=tipoSusp;
		this.peso=peso;
	}
	
	
	//
	public String getMaterialPed() {
		return materialPed;
	}

	public void setMaterialPed(String materialPed) {
		this.materialPed = materialPed;
	}

	public String getTipoSusp() {
		return tipoSusp;
	}

	public void setTipoSusp(String tipoSusp) {
		this.tipoSusp = tipoSusp;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	//
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
