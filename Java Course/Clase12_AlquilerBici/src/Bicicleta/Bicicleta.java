package Bicicleta;

public abstract class Bicicleta implements Biciclo {
	//Atributo para la implementación
	protected int velocidad;
	
	//Atributos en común Bici
	protected String marca;
	protected String modelo;
	protected String serie;
	protected int nroAro;
	protected double montoAlq;
	protected String tipo;
	
	//Cosntructor abstracto
	public  Bicicleta(String marca, String modelo, String serie, int nroAro, double montoAlq, String tipo) {
		this.marca = marca;
		this.modelo = modelo;
		this.serie = serie;
		this.nroAro = nroAro;
		this.montoAlq = montoAlq;
		this.tipo = tipo;
	}
	
	public  Bicicleta() {
		
	}

	//
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getNroAro() {
		return nroAro;
	}

	public void setNroAro(int nroAro) {
		this.nroAro = nroAro;
	}

	public double getMontoAlq() {
		return montoAlq;
	}

	public void setMontoAlq(double montoAlq) {
		this.montoAlq = montoAlq;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	//Método abstracto
	public abstract void Girar();

	//Implementación de la interfaz
	@Override
	public void DisminuirVelocidad() {
		for (int i = velocidad; i >= 0;i--) {
			System.out.println("Disminuyendo la velocidad: " + velocidad);
			velocidad--;
		}
	}

	@Override
	public void AumentarVelocidad(int cantidad) {
		for (int i = 0; i <=cantidad;i++) {
			System.out.println("Aumentando la velocidad: " + velocidad);
			velocidad++;
		}
	}
	
}
