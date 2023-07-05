package VueloReserva;


public class ReservaVuelo {
	private String ciudadOrigen;
	private String ciudadDestino;
	private char tipoReserva;
	private String fechaSalida;
	private String fechaVuelta;
	private int cantidadPasaj;
	private char tipoCabina;
	private double precioBase;
	private double montoAbonar;
	//
	public ReservaVuelo(){
		
	}

	public ReservaVuelo(String ciudadOrigen, String ciudadDestino, char tipoReserva, String fechaSalida,
			String fechaVuelta, int cantidadPasaj, char tipoCabina) {
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.tipoReserva = tipoReserva;
		this.fechaSalida = fechaSalida;
		this.fechaVuelta = fechaVuelta;
		this.cantidadPasaj = cantidadPasaj;
		this.tipoCabina = tipoCabina;
	}

	//
	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public char getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(char tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(String fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}

	public int getCantidadPasaj() {
		return cantidadPasaj;
	}

	public void setCantidadPasaj(int cantidadPasaj) {
		this.cantidadPasaj = cantidadPasaj;
	}

	public char getTipoCabina() {
		return tipoCabina;
	}

	public void setTipoCabina(char tipoCabina) {
		this.tipoCabina = tipoCabina;
	}
	
	//Método para calcular el Precio Base del pasaje
	public double ObtenerPrecioBase(int edad) {
		this.precioBase = (((70-edad)*2.5)/91)*550758;
		return this.precioBase;
	}
	
	//Método para calcular el monto total a abonar
	public double ObtenerMontoTotal(int categoria) {
		this.montoAbonar=0;
		//Evaluar categoría del pasajero 
		if(categoria==111) {
			//Primer cuadro
			if(this.getTipoReserva()=='I') {
				if(this.getTipoCabina()=='E') {
					this.montoAbonar=(this.precioBase*1.375*0.65)*this.getCantidadPasaj();
				}else if(this.getTipoCabina()=='N') {
					this.montoAbonar=(this.precioBase*1.375*1.07)*this.getCantidadPasaj();
				}else {
					this.montoAbonar=(this.precioBase*1.375*1.30)*this.getCantidadPasaj();
				}
			}else if(this.getTipoReserva()=='V') {
				if(this.getTipoCabina()=='E') {
					this.montoAbonar=(this.precioBase*1.609*0.65)*this.getCantidadPasaj();
				}else if(this.getTipoCabina()=='N') {
					this.montoAbonar=(this.precioBase*1.609*1.07)*this.getCantidadPasaj();
				}else {
					this.montoAbonar=(this.precioBase*1.609*1.30)*this.getCantidadPasaj();
				}
			}else {
				if(this.getTipoCabina()=='E') {
					this.montoAbonar=(this.precioBase*1.987*0.65)*this.getCantidadPasaj();
				}else if(this.getTipoCabina()=='N') {
					this.montoAbonar=(this.precioBase*1.987*1.07)*this.getCantidadPasaj();
				}else {
					this.montoAbonar=(this.precioBase*1.987*1.30)*this.getCantidadPasaj();
				}
			}
		}else {
			if(categoria==222) {
				//Segundo Cuadro
				if(this.getTipoReserva()=='I') {
					if(this.getTipoCabina()=='E') {
						this.montoAbonar=(this.precioBase*1.430*0.95)*this.getCantidadPasaj();
					}else if(this.getTipoCabina()=='N') {
						this.montoAbonar=(this.precioBase*1.430*1.23)*this.getCantidadPasaj();
					}else {
						this.montoAbonar=(this.precioBase*1.430*1.48)*this.getCantidadPasaj();
					}
				}else if(this.getTipoReserva()=='V') {
					if(this.getTipoCabina()=='E') {
						this.montoAbonar=(this.precioBase*1.796*0.95)*this.getCantidadPasaj();
					}else if(this.getTipoCabina()=='N') {
						this.montoAbonar=(this.precioBase*1.796*1.23)*this.getCantidadPasaj();
					}else {
						this.montoAbonar=(this.precioBase*1.796*1.48)*this.getCantidadPasaj();
					}
				}else {
					if(this.getTipoCabina()=='E') {
						this.montoAbonar=(this.precioBase*2.148*0.95)*this.getCantidadPasaj();
					}else if(this.getTipoCabina()=='N') {
						this.montoAbonar=(this.precioBase*2.148*1.23)*this.getCantidadPasaj();
					}else {
						this.montoAbonar=(this.precioBase*2.148*1.48)*this.getCantidadPasaj();
					}
				}
			}
		}
		return this.montoAbonar;
	}

	//Método para mostrar
	@Override
	public String toString() {
		return "ReservaVuelo [getCiudadOrigen()=" + getCiudadOrigen() + ", getCiudadDestino()=" + getCiudadDestino()
				+ ", getTipoReserva()=" + getTipoReserva() + ", getFechaSalida()=" + getFechaSalida()
				+ ", getFechaVuelta()=" + getFechaVuelta() + ", getCantidadPasaj()=" + getCantidadPasaj()
				+ ", getTipoCabina()=" + getTipoCabina() + "]";
	}
	
	
}
