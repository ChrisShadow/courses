package HabitacionReserva;

//import HabitacionReserva.ExceptionSalesSlip;

public class ClienteReserva {
	private int idCliente ;
	private String razonSocial;
	private int nroEdificio;
	private int nroPiso;
	private int nroDto;
	private Character tipoHabitacion;
	private double precioBase;
	private int cantDias;
	private double montoFactura;
	private double recargo;
	
	//
	public ClienteReserva() {
		
	}

	//
	public ClienteReserva(int idCliente, String razonSocial, int nroEdificio, int nroPiso, int nroDto,
			char tipoHabitacion, double precioBase, int cantDias) {
		this.idCliente = idCliente;
		this.razonSocial = razonSocial;
		this.nroEdificio = nroEdificio;
		this.nroPiso = nroPiso;
		this.nroDto = nroDto;
		this.tipoHabitacion = tipoHabitacion;
		this.precioBase = precioBase;
		this.cantDias = cantDias;
	}

	//
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public int getNroEdificio() {
		return nroEdificio;
	}

	public void setNroEdificio(int nroEdificio) {
		this.nroEdificio = nroEdificio;
	}

	public int getNroPiso() {
		return nroPiso;
	}

	public void setNroPiso(int nroPiso) {
		this.nroPiso = nroPiso;
	}

	public int getNroDto() {
		return nroDto;
	}

	public void setNroDto(int nroDto) {
		this.nroDto = nroDto;
	}

	public Character getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(char tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public double getMontoFactura() {
		return montoFactura;
	}

	public void setMontoFactura(double montoFactura) {
		this.montoFactura = montoFactura;
	}

	public double getRecargo() {
		return recargo;
	}

	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}

	@Override
	public String toString() {
		return "El id del cliente: " + getIdCliente() + ", su razón social: " + getRazonSocial()
				+ ", con nro del edificio: " + getNroEdificio() + ", en el nro de piso:  " + getNroPiso() + ", y nro del departamento: "
				+ getNroDto() + ". El tipo de habitación reservado: " + getTipoHabitacion() + ", con precio base: " + getPrecioBase()
				+ ", días reservados: " + getCantDias() + ", total de la factura a abonar: " + getMontoFactura() + ", y con recargo de: "
				+ getRecargo() + ".";
	}
	
	//Método para obtner el recargo según tipo habitación
	public void ObtenerRecargo() {
		double recargo=0;
		switch(this.getTipoHabitacion()) {
		case 'c':
			recargo=1.750;
			break;
		case 'd':
			recargo=1.557;
			break;
		case 'm':
			recargo=2.039;
			break;
		case 's':
			recargo=0.097;
			break;
		case 'v':
			recargo=2.350;
			break;	
		default:
			recargo=0;
			break;
		}
		this.setRecargo(recargo);
	}
	
	
	
	
	//Método para calcular el monto de la factura
	
	public void CalularMontoFactura() {
			double montofact=0;
			montofact=((this.getPrecioBase()*this.getCantDias())*this.getRecargo())-(this.getCantDias()*750);
			this.setMontoFactura(montofact);
	}
	
	
	
	
	
}

