
public class Equipo {
	private int idEq;
	private String nombre;
	private int limJug;
	
	//
	
	public Equipo() {
	
	}

	
	public Equipo(int idEq) {
		this.idEq = idEq;
	}

	public Equipo(String nombre) {
		this.nombre = nombre;
		this.limJug = 25;
	}

	public Equipo(int idEq, String nombre, int limJug) {
		this.idEq = idEq;
		this.nombre = nombre;
		this.limJug = limJug;
	}

	public int getIdEq() {
		return idEq;
	}

	public void setIdEq(int idEq) {
		this.idEq = idEq;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLimJug() {
		return limJug;
	}

	public void setLimJug(int limJug) {
		this.limJug = limJug;
	}


	@Override
	public String toString() {
		return "Identificador del equipo: " + getIdEq() + "\nNombe del club: " + getNombre() + "\nLímite de jugadores: " + getLimJug();
	}
	
	
	
}
