package Bicicleta;

public class Carrera extends Bicicleta {
	private int cantVeloc;
	private String tipoFre;
	private String materBic;
	
	//
	public Carrera() {
		super();
	}

	public Carrera(String marca, String modelo, String serie, int nroAro, double montoAlq, String tipo,int cantVeloc,String tipoFre,String materBic) {
		super(marca, modelo, serie, nroAro, montoAlq, tipo);
		this.cantVeloc=cantVeloc;
		this.tipoFre=tipoFre;
		this.materBic=materBic;
	}
	
	//
	public int getCantVeloc() {
		return cantVeloc;
	}

	public void setCantVeloc(int cantVeloc) {
		this.cantVeloc = cantVeloc;
	}

	public String getTipoFre() {
		return tipoFre;
	}

	public void setTipoFre(String tipoFre) {
		this.tipoFre = tipoFre;
	}

	public String getMaterBic() {
		return materBic;
	}

	public void setMaterBic(String materBic) {
		this.materBic = materBic;
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
