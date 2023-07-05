package Vacunacion.Modelo;


public class Vacuna {
	
	private Usuario id;
	private int nroDosis;
	private String vacuna;
	private String lote;
	private String fechaAp;
	private int nroDep;
	private String distrito;
	
	//
	public Vacuna() {
		
	}
	
	
	//Con Pk
	public Vacuna(Usuario id, int nroDosis) {
		this.id = id;
		this.nroDosis = nroDosis;
	}

	
	//Con valores de inserción sin dosis, 
	public Vacuna(String vacuna, String lote, String fechaAp, int nroDep, String distrito) {
		this.vacuna = vacuna;
		this.lote = lote;
		this.fechaAp = fechaAp;
		this.nroDep = nroDep;
		this.distrito = distrito;
	}


	//Con valores de operación con dosis
	public Vacuna(int nroDosis, String vacuna, String lote, String fechaAp, int nroDep, String distrito) {
		this.nroDosis = nroDosis;
		this.vacuna = vacuna;
		this.lote = lote;
		this.fechaAp = fechaAp;
		this.nroDep = nroDep;
		this.distrito = distrito;
	}

	//Con valores de operación con PK
	public Vacuna(Usuario id, int nroDosis, String vacuna, String lote, String fechaAp, int nroDep, String distrito) {
		this.id = id;
		this.nroDosis = nroDosis;
		this.vacuna = vacuna;
		this.lote = lote;
		this.fechaAp = fechaAp;
		this.nroDep = nroDep;
		this.distrito = distrito;
	}

	//
	public Usuario getId() {
		return id;
	}


	public void setId(Usuario id) {
		this.id = id;
	}


	public int getNroDosis() {
		return nroDosis;
	}


	public void setNroDosis(int nroDosis) {
		this.nroDosis = nroDosis;
	}


	public String getVacuna() {
		return vacuna;
	}


	public void setVacuna(String vacuna) {
		this.vacuna = vacuna;
	}


	public String getLote() {
		return lote;
	}


	public void setLote(String lote) {
		this.lote = lote;
	}


	public String getFechaAp() {
		return fechaAp;
	}


	public void setFechaAp(String fechaAp) {
		this.fechaAp = fechaAp;
	}


	public int getNroDep() {
		return nroDep;
	}


	public void setNroDep(int nroDep) {
		this.nroDep = nroDep;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	@Override
	public String toString() {
		return "\nIdentificador de la vacuna: " + getId().toString()+ "\nNro. Dosis: " + getNroDosis() + "\nNombre de la vacuna: " + getVacuna()
				+ "\nLote: " + getLote() + "\nFecha de la apliación: " + getFechaAp() + "\nNro. Departamento: " + getNroDep()
				+ "\nDistrito: " + getDistrito() + "\n";
	}
	
	
	
	
}
