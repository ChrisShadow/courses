
public class Jugador {
	private long idjug;
	private String nroDoc;
	private String tipoDoc;
	private String nombre;
	private String apellido;
	private String fechaNac;
	private int totTarAm;
	private int totTarRo;
	private Equipo idEqu;
	private int totTanConv;
	
	//
	public Jugador() {
		super();
		this.totTanConv=0;
		this.totTarAm=0;
		this.totTarRo=0;
		
	}
	
	public Jugador(String nroDoc, String tipoDoc, String nombre, String apellido, String fechaNac,
			Equipo idEqu) {
		this.nroDoc = nroDoc;
		this.tipoDoc = tipoDoc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.idEqu = idEqu;
		this.totTanConv=0;
		this.totTarAm=0;
		this.totTarRo=0;
	}

	public Jugador(long idjug, String nroDoc, String tipoDoc, String nombre, String apellido, String fechaNac,
			Equipo idEqu) {
		this.idjug = idjug;
		this.nroDoc = nroDoc;
		this.tipoDoc = tipoDoc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.idEqu = idEqu;
		this.totTanConv=0;
		this.totTarAm=0;
		this.totTarRo=0;
	}

	//
	public long getIdjug() {
		return idjug;
	}

	public void setIdjug(long idjug) {
		this.idjug = idjug;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public int getTotTarAm() {
		return totTarAm;
	}

	public void setTotTarAm(int totTarAm) {
		this.totTarAm = totTarAm;
	}

	public int getTotTarRo() {
		return totTarRo;
	}

	public void setTotTarRo(int totTarRo) {
		this.totTarRo = totTarRo;
	}

	public Equipo getIdEqu() {
		return idEqu;
	}

	public void setIdEqu(Equipo idEqu) {
		this.idEqu = idEqu;
	}

	public int getTotTanConv() {
		return totTanConv;
	}

	public void setTotTanConv(int totTanConv) {
		this.totTanConv = totTanConv;
	}

	@Override
	public String toString() {
		return "Identificador del Jugador: " + getIdjug() + "\nNro. de Documento: " + getNroDoc() + "\nTipo de Documento: " + getTipoDoc()
				+ "\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nFecha de Nacimineto: "
				+ getFechaNac() + "\nCantidad de tarjetas amarillas: " + getTotTarAm() + "\nCantidad de tarjetas rojas: " + getTotTarRo()
				+ "\nDatos del equipo: \n" + getIdEqu().toString() + "\nCantidad total de goles a favor: " + getTotTanConv();
	}
	
	
	
	
	
	
	
}
