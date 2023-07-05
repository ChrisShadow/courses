package Modelo;

import java.util.Objects;

public class Equipo implements Comparable<Equipo>{
	private int nroEquipo;
	private String nombreEquipo;
	private String entrenador;
	private String anhoTorneo;
	private CodigoTemporada codTemporada;
	private Estado estado;
	private String ciudad;
	private int nroPartidosGanados;
	private int nroPartidosPerdidos;
	private int nroPartidosEmpatados;
	private int rankingNacional;
	private int golesMarcados;
	private int golesRecibidos;
	
	public Equipo() {
		super();
	}

	public Equipo(int nroEquipo, String nombreEquipo, String entrenador, String anhoTorneo,
			CodigoTemporada codTemporada, Estado estado, String ciudad, int nroPartidosGanados, int nroPartidosPerdidos,
			int nroPartidosEmpatados, int rankingNacional, int golesMarcados, int golesRecibidos) {
		this.nroEquipo = nroEquipo;
		this.nombreEquipo = nombreEquipo;
		this.entrenador = entrenador;
		this.anhoTorneo = anhoTorneo;
		this.codTemporada = codTemporada;
		this.estado = estado;
		this.ciudad = ciudad;
		this.nroPartidosGanados = nroPartidosGanados;
		this.nroPartidosPerdidos = nroPartidosPerdidos;
		this.nroPartidosEmpatados = nroPartidosEmpatados;
		this.rankingNacional = rankingNacional;
		this.golesMarcados = golesMarcados;
		this.golesRecibidos = golesRecibidos;
	}

	public int getNroEquipo() {
		return nroEquipo;
	}

	public void setNroEquipo(int nroEquipo) {
		this.nroEquipo = nroEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}

	public String getAnhoTorneo() {
		return anhoTorneo;
	}

	public void setAnhoTorneo(String anhoTorneo) {
		this.anhoTorneo = anhoTorneo;
	}

	public CodigoTemporada getCodTemporada() {
		return codTemporada;
	}

	public void setCodTemporada(CodigoTemporada codTemporada) {
		this.codTemporada = codTemporada;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getNroPartidosGanados() {
		return nroPartidosGanados;
	}

	public void setNroPartidosGanados(int nroPartidosGanados) {
		this.nroPartidosGanados = nroPartidosGanados;
	}

	public int getNroPartidosPerdidos() {
		return nroPartidosPerdidos;
	}

	public void setNroPartidosPerdidos(int nroPartidosPerdidos) {
		this.nroPartidosPerdidos = nroPartidosPerdidos;
	}

	public int getNroPartidosEmpatados() {
		return nroPartidosEmpatados;
	}

	public void setNroPartidosEmpatados(int nroPartidosEmpatados) {
		this.nroPartidosEmpatados = nroPartidosEmpatados;
	}

	public int getRankingNacional() {
		return rankingNacional;
	}

	public void setRankingNacional(int rankingNacional) {
		this.rankingNacional = rankingNacional;
	}

	public int getGolesMarcados() {
		return golesMarcados;
	}

	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}

	public int getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}

	@Override
	public String toString() {
		return "\nNroEquipo: " + getNroEquipo() + "\nNombreEquipo: " + getNombreEquipo()
				+ "\nEntrenador: " + getEntrenador() + "\nAnhoTorneo: " + getAnhoTorneo()
				+ "\nCodTemporada: " + getCodTemporada() + "\nEstado: " + getEstado() + "\nCiudad: "
				+ getCiudad() + "\nNroPartidosGanados: " + getNroPartidosGanados() + "\nNroPartidosPerdidos: "
				+ getNroPartidosPerdidos() + "\nNroPartidosEmpatados: " + getNroPartidosEmpatados()
				+ "\nRankingNacional: " + getRankingNacional() + "\nGolesMarcados: " + getGolesMarcados()
				+ "\nGolesRecibidos: " + getGolesRecibidos() + "\n";
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(estado, rankingNacional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return estado == other.estado && rankingNacional == other.rankingNacional;
	}

	@Override
	public int compareTo(Equipo o) {
		
		int banN=0;
		//this hPosterior y o hAnterior-->Punteros de la lista.
		if ((this.getEstado().toString().charAt(0) < o.getEstado().toString().charAt(0)) && (this.getRankingNacional() < o.getRankingNacional())) {
            banN=1; //
        } else if ((this.getEstado().toString().charAt(0) > o.getEstado().toString().charAt(0)) && (this.getRankingNacional() > o.getRankingNacional())) {
        	 banN=-1;
        } else {
        	 banN=0;
        }
		return banN;
	}
	
	
	
	//Para JUnit
	public String toJson() {
		String res="[{";
		res+="\"nroEquipo\":"+this.getNroEquipo();
		res+="\"nombreEquipo\":"+this.getNombreEquipo();
		res+="\"entrenador\":"+this.getEntrenador();
		res+="\"anhoTorneo\":"+this.getAnhoTorneo();
		res+="\"codTemporada\":"+this.getCodTemporada().toString();
		res+="\"estado\":"+this.getEstado().toString();
		res+="\"ciudad\":"+this.getCiudad();
		res+="\"nroPartidosGanados\":"+this.getNroPartidosGanados();
		res+="\"nroPartidosPerdidos\":"+this.getNroPartidosPerdidos();
		res+="\"nroPartidosEmpatados\":"+this.getNroPartidosEmpatados();
		res+="\"rankingNacional\":"+this.getRankingNacional();
		res+="\"golesMarcados\":"+this.getGolesMarcados();
		res+="\"golesRecibidos\":"+this.getGolesRecibidos();
		res+="}]";		
		return res;
	}
	
	
	
	
	
}
